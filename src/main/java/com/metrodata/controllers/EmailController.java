package com.metrodata.controllers;

import com.metrodata.entities.models.EmailData;
import com.metrodata.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("email")
    public EmailData sendEmail(@RequestBody EmailData emailData) {
        return emailService.sendEmail(emailData);
    }

    @PostMapping("email-html")
    public EmailData sendEmailWithHTML(@RequestBody EmailData emailData) {
        return emailService.sendEmailHTML(emailData);
    }

}
