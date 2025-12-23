package br.com.email_service.core;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmailRequest(
        @NotBlank
        @Email
        String toEmail,

        @NotBlank
        @Size(max = 255)
        String subject,

        @NotBlank
        String body
) {
}
