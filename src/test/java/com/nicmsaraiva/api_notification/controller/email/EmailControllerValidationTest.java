package com.nicmsaraiva.api_notification.controller.email;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicmsaraiva.api_notification.controller.EmailController;
import com.nicmsaraiva.api_notification.service.EmailService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmailController.class)
public class EmailControllerValidationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnBadRequestWhenAllFieldPayloadInvalidLength() throws Exception {
        Map<String, Object> payload = Map.of(
                "subject", "Short",
                "email", "not-an-email",
                "content", ""
        );

        mockMvc.perform(post("/notifications/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Subject must be between")))
                .andExpect(content().string(Matchers.containsString("Invalid email format")));
    }

    @Test
    void shouldReturnBadRequestDateSentNull() throws Exception {
        Map<String, Object> payload = Map.of(
                "subject", "Test Subject Valid Length",
                "email", "nicmsaraiva@gmail.com",
                "content", "This is a valid content"
        );

        mockMvc.perform(post("/notifications/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Sent date cannot be null")));
    }

    @Test
    void shouldReturnBadRequestAllFieldsNull() throws Exception {
        Map<String, Object> payload = Map.of();

        mockMvc.perform(post("/notifications/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Sent date cannot be null")))
                .andExpect(content().string(Matchers.containsString("Email cannot be blank")))
                .andExpect(content().string(Matchers.containsString("Content cannot be blank")))
                .andExpect(content().string(Matchers.containsString("Subject cannot be blank")));
    }

    @Test
    void shouldReturnBadRequestFieldEmailInvalidFormat() throws Exception {
        Map<String, Object> payload = Map.of(
                "subject", "Test Subject Valid Length",
                "email", "nicmsaraiva.com",
                "content", "This is a valid content");

        mockMvc.perform(post("/notifications/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Invalid email format")));
    }
}
