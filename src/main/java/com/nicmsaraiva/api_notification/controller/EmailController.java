package com.nicmsaraiva.api_notification.controller;

import com.nicmsaraiva.api_notification.dto.email.CreateEmailDTO;
import com.nicmsaraiva.api_notification.dto.email.ReadEmailDTO;
import com.nicmsaraiva.api_notification.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/notifications")
public class EmailController {

    private final EmailService service;

    @Autowired
    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping("/email")
    public ResponseEntity<String> createEmail(@Valid @RequestBody CreateEmailDTO createEmailDTO) {
        try {
            service.save(createEmailDTO);
            return new ResponseEntity<>("Email notification created!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Failed to create a email notification!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/email")
    public ResponseEntity<List<ReadEmailDTO>> getEmails() {
        return ResponseEntity.ok(service.getEmails().stream().map(ReadEmailDTO::new).toList());
    }

    @GetMapping("/email/{id}")
    public ResponseEntity<ReadEmailDTO> getEmailById(@PathVariable Long id) {
        return service.getById(id)
                .map(emailNotification -> ResponseEntity.ok(new ReadEmailDTO(emailNotification)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
