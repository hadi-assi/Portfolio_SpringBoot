package com.abd.protfolio.Email.Services;

import com.abd.protfolio.Email.Entities.ContactEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendMessage(String ReceiverEmail , String subject , String content)
    {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(senderEmail);
        message.setTo(ReceiverEmail);
        message.setSubject(subject);
        message.setText(content);

        emailSender.send(message);
    }

    public void sendToSelf(ContactEntity contact)
    {
        sendMessage(senderEmail , "Contact me Portfolio" , contact.toString());
    }




}
