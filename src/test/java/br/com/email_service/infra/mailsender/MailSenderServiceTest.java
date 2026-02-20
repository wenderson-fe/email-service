package br.com.email_service.infra.mailsender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MailSenderServiceTest {
    private JavaMailSender javaMailSender;
    private MailSenderService mailSenderService;
    private String from;

    @BeforeEach
    void setUp() {
        javaMailSender = mock(JavaMailSender.class);
        from = "noreply@empresa.com";
        mailSenderService = new MailSenderService(javaMailSender, from);
    }

    @Test
    @DisplayName("Deve criar um SimpleMailMessage com os parâmetros corretos")
    void deveCriarSimpleMailMessageCorreto() {
        String toEmail = "emaitest@test.com";
        String subject = "test subject";
        String body = "test body";

        mailSenderService.sendEmail(toEmail, subject, body);

        ArgumentCaptor<SimpleMailMessage> messageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(javaMailSender, times(1)).send(messageCaptor.capture());
        SimpleMailMessage capturedMessage = messageCaptor.getValue();

        Assertions.assertEquals(from, capturedMessage.getFrom());
        Assertions.assertEquals(toEmail, capturedMessage.getTo()[0]);
        Assertions.assertEquals(subject, capturedMessage.getSubject());
        Assertions.assertEquals(body, capturedMessage.getText());
    }
}