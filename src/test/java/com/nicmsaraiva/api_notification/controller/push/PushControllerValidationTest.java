package com.nicmsaraiva.api_notification.controller.push;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicmsaraiva.api_notification.controller.PushController;
import com.nicmsaraiva.api_notification.service.PushService;
import com.nicmsaraiva.api_notification.utils.Utils;
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

@WebMvcTest(PushController.class)
public class PushControllerValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PushService pushService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnBadRequestWhenAllFieldPayloadInvalidLength() throws Exception {
        Map<String, String> payload = Map.of(
                "title", "Short",
                "message", Utils.stringGenerator(501),
                "deviceToken", "122311441"
        );

        mockMvc.perform(post("/notifications/push")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Title must be between 10 and 100 characters")))
                .andExpect(content().string(Matchers.containsString("Message must be at most 500 characters")))
                .andExpect(content().string(Matchers.containsString("Device token  must be between 10 and 50 characters")));
    }
}
