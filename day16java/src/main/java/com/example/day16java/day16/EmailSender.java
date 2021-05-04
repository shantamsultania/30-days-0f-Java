package com.example.day16java.day16;

import javax.mail.*;
import java.util.Properties;

public class EmailSender {


    public void sendCustomEmail(String link, String recipient) {
        // email ID of  Sender.
        String user_name_sender = "shantam12300@gmail.com";
        String password = "your password ";


//         Setting up mail server
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", false);


//        try {
//            // creating session object to get properties
//
//            Session session = Session.getDefaultInstance(props,
//                    new Authenticator() {
//                        protected PasswordAuthentication getPasswordAuthentication() {
//                            return new PasswordAuthentication(user_name_sender, password);
//                        }
//                    });
//
//            // MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From Field: adding senders email to from field.
//            message.setFrom(new InternetAddress(user_name_sender));
//
//            // Set To Field: adding recipient's email to from field.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//
//            // Set Subject: subject of the email
//            message.setSubject("Email Verification");
//
//            // set body of the email.
//            message.setText("This is your verification link " + link);
//
//            // Send email.
//            Transport.send(message);
//            System.out.println("Mail successfully sent");
//        } catch (Exception e) {
//            System.out.println("Mail successfully sent " + e.getMessage());
//        }
    }

}
