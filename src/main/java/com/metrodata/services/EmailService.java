package com.metrodata.services;

import com.metrodata.entities.models.EmailData;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    public EmailData sendEmail(EmailData emailData) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("obedputro@gmail.com");
            message.setTo(emailData.getTo());
            message.setSubject(emailData.getSubject());
            message.setText(emailData.getBody());

            mailSender.send(message);
            System.out.println("Email Sent");
            return emailData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EmailData sendEmailWithHTML(Context context, EmailData emailData) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            String body = templateEngine.process("email-sender", context);

            messageHelper.setFrom("obedputro@gmail.com");
            messageHelper.setTo(emailData.getTo());
            messageHelper.setSubject(emailData.getSubject());
            messageHelper.setText(body, true);

            mailSender.send(message);
            System.out.println("Email Sent");
            return emailData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EmailData sendEmailHTML(EmailData emailData) {
        Context context = new Context();
        context.setVariable("to", emailData.getTo());
        context.setVariable("subject", emailData.getSubject());
        context.setVariable("body", emailData.getBody());

        sendEmailWithHTML(context, emailData);
        return emailData;
    }
}
