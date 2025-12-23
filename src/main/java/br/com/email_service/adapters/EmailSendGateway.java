package br.com.email_service.adapters;

public interface EmailSendGateway {
    void sendEmail(String toEmail, String subject, String body);
}
