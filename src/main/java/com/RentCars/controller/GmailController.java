package com.RentCars.controller;

import com.RentCars.entity.Gmail;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Controller
public class GmailController {

    private static final Logger log = Logger.getLogger(com.RentCars.controller.GmailController.class);

    public final JavaMailSender emailSender;

    public GmailController(@Qualifier("getJavaMailSender") JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendSimpleEmail() throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();



        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(Gmail.FRIEND_EMAIL);
        helper.setSubject("RENT");

        helper.setText("CREATE CONTRACT");

        String path = "C:/Users/tsybi/Desktop/logging.log";


        FileSystemResource file = new FileSystemResource(new File(path));
        helper.addAttachment("Rent", file);


        emailSender.send(message);


        return "Сообщение отправлено!";
    }
}
