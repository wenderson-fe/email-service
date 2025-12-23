package br.com.email_service.core.cases;

public interface EmailSendUseCase {
    void sendEmail(String toEmail, String subject, String body);
}
