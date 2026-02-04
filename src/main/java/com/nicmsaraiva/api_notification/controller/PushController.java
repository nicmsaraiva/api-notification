package com.nicmsaraiva.api_notification.controller;

import com.nicmsaraiva.api_notification.dto.push.CreatePushDTO;
import com.nicmsaraiva.api_notification.dto.push.ReadPushDTO;
import com.nicmsaraiva.api_notification.service.PushService;
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
public class PushController {
    private final PushService service;

    @Autowired
    public PushController(PushService service) {
        this.service = service;
    }

    @PostMapping("/push")
    public ResponseEntity<String> createPush(@Valid @RequestBody CreatePushDTO createPushDTO) {
        try {
            service.save(createPushDTO);
            return new ResponseEntity<>("Push notification created!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create a push notification!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pushes")
    public ResponseEntity<List<ReadPushDTO>> getPushes() {
        return ResponseEntity.ok(service.getPushes().stream().map(ReadPushDTO::new).toList());
    }

    @GetMapping("/push/{id}")
    public ResponseEntity<ReadPushDTO> getPushByID(@PathVariable Long id) {
        return service.getById(id)
                .map(pushNotification -> ResponseEntity.ok(new ReadPushDTO(pushNotification)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
