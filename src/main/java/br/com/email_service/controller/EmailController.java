package br.com.email_service.controller;

import br.com.email_service.application.EmailSendService;
import br.com.email_service.core.EmailRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {
    private final EmailSendService service;

    public EmailController(EmailSendService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailRequest email) {
        service.sendEmail(email.toEmail(), email.subject(), email.body());
        return ResponseEntity.ok("Email enviado com sucesso!");
    }
}
