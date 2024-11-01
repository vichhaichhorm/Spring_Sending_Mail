package com.vichhaicoder.userservice_send_mail.service;


import org.springframework.stereotype.Service;

@Service

public interface EmailService {
    void sendSimpleMailMessage(String message, String to, String token);
    void sendMimeMailWithAttachments(String message, String to, String token);
    void sendMimeMailWithEmbeddedImages(String message, String to, String token);
    void sendMimeMailWithEmbeddedFiles(String message, String to, String token);
    void sendHtmlEmail(String message, String to, String token);
    void sendHtmlEmailWithEmbeddedFiles(String message, String to, String token);

}
