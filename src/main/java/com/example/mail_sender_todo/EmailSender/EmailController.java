package com.example.mail_sender_todo.EmailSender;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String body) {
        emailService.sendSimpleEmail(toEmail, subject, body);
        return "Email sent successfully!";
    }

    @GetMapping("/send-mime-email")
    public String sendMimeEmail(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String body) {
        try {
            emailService.sendMimeEmail(toEmail, subject, body);
            return "Mime Email sent successfully!";
        } catch (MessagingException e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}
