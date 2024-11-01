package com.vichhaicoder.userservice_send_mail.service.serviceimp;

import com.vichhaicoder.userservice_send_mail.service.EmailService;
import com.vichhaicoder.userservice_send_mail.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImp implements EmailService {
    public static final String NEW_USER_ACCOUNT_VERIFICATION = "NEW_USER_ACCOUNT_VERIFICATION";
    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String formEmail;


    private final JavaMailSender mailSender;

    @Override
    public void sendSimpleMailMessage(String name, String to, String token) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            mailMessage.setFrom(formEmail);
            mailMessage.setTo(to);
            mailMessage.setText(EmailUtils.getEmailMessage(name,host,token));
            mailSender.send(mailMessage);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }

    }

    @Override
    public void sendMimeMailWithAttachments(String message, String to, String token) {

    }

    @Override
    public void sendMimeMailWithEmbeddedImages(String message, String to, String token) {

    }

    @Override
    public void sendMimeMailWithEmbeddedFiles(String message, String to, String token) {

    }

    @Override
    public void sendHtmlEmail(String message, String to, String token) {

    }

    @Override
    public void sendHtmlEmailWithEmbeddedFiles(String message, String to, String token) {

    }
}
