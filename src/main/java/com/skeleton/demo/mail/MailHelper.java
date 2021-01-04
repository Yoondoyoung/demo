package com.skeleton.demo.mail;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

public class MailHelper {
    public JavaMailSender sender;
    public MimeMessage message;
    public MimeMessageHelper messageHelper;

    public MailHelper(JavaMailSender sender) throws MessagingException {
        this.sender = sender;
        message = sender.createMimeMessage();
        messageHelper = new MimeMessageHelper(message,true,"utf-8");
    }

    public void setFrom(String fromEmail) throws MessagingException{
        messageHelper.setFrom(fromEmail);
    }

    public void setTo(String email) throws MessagingException{
        messageHelper.setTo(email);
    }

    public void setText(String text, boolean useHtml) throws MessagingException{
        messageHelper.setText(text,useHtml);
    }

    public void setInline(String contentId, String pathToInline) throws MessagingException, IOException {
        File file = new ClassPathResource(pathToInline).getFile();
        FileSystemResource fsr = new FileSystemResource(file);

        messageHelper.addInline(contentId,fsr
        );
    }

    public void send(){
        try{
            sender.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void setSubject(String subject) throws MessagingException {
        messageHelper.setSubject(subject);
    }
}
