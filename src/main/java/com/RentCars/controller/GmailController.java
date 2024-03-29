package com.RentCars.controller;

import com.RentCars.dao.Gmail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
@RequestMapping("/sendEmail")
public class GmailController {

    public final JavaMailSender emailSender;

    public  boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAdd = new InternetAddress(email);
            emailAdd.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }


    public GmailController(@Qualifier("getJavaMailSender") JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @GetMapping
    public String sendSimpleEmail() throws MessagingException{

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(Gmail.FRIEND_EMAIL);

        helper.setSubject("ORDER");
        helper.setText("CREATE CONTRACT!!!");

        String path = "D:/logging.log";
        FileSystemResource file = new FileSystemResource(new File(path));
        helper.addAttachment("Order", file);

        emailSender.send(message);

        return "Сообщение отправлено!Ожидайте ответ!!!";
    }

}
