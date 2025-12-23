package br.com.email_service.application;

import br.com.email_service.adapters.EmailSendGateway;
import br.com.email_service.core.cases.EmailSendUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService implements EmailSendUseCase {
    private final EmailSendGateway emailSend;

    public EmailSendService(EmailSendGateway emailSend) {
        this.emailSend = emailSend;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        emailSend.sendEmail(toEmail, subject, body);
    }
}
