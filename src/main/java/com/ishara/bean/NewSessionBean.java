/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishara.bean;

import javax.ejb.Stateless;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author MR.Cutevil
 */
@Stateless
public class NewSessionBean {
   
    public void sendEmail(String email, String subject, String message){
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
  
        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sumitbabucutevil", "vivalarasa");
                }
            });
  
        try {
  
            Message mmessage = new MimeMessage(session);
            mmessage.setFrom(new InternetAddress("sumitbabucutevil"));
            mmessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            mmessage.setSubject(subject);
            mmessage.setText(message);
  
            Transport.send(mmessage);
  
            System.out.println("Done");
  
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

