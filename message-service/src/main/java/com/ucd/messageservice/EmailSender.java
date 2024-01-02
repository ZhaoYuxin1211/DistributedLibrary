package com.ucd.messageservice;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@RequiredArgsConstructor
public class EmailSender {
    public void sendEmail(String toEmail, String subject, String body){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        simpleMailMessage.setFrom("DistributedLibrary<distributedlib@hotmail.com>");
        simpleMailMessage.setTo(toEmail);

        javaMailSender.setHost("smtp-mail.outlook.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("distributedlib@hotmail.com");
        javaMailSender.setPassword("COMP41720");
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");

        javaMailSender.send(simpleMailMessage);

    }
}
