package com.example.day16java.day16;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

@Service
public
class FirebaseAuthenticationDemo {

    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private final UserRecord.CreateRequest request = new UserRecord.CreateRequest();

    public void createUserWithEmailPassword(String email, String password) {

        try {
            UserRecord userRecord = firebaseAuth.createUser(request.setEmail(email).setPassword(password));
            System.out.println("Successfully created new user: " + userRecord.getUid());
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
    }

    public void createUserWithPhoneNumber(String phoneNumber) {

        try {
            UserRecord userRecord = firebaseAuth.createUser(request.setPhoneNumber(phoneNumber));
            System.out.println("Successfully created new user: " + userRecord.getUid());
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
    }

    public void verifyEmail(String email) {

        try {

            String link = firebaseAuth.generateEmailVerificationLink(email);
//            EmailSender emailSender = new EmailSender();
//            emailSender.sendCustomEmail(link, email);
            System.out.println(link);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
    }

    public void userByEmail(String email) {

        try {
            UserRecord user = firebaseAuth.getUserByEmail(email);
            if (user != null) {
                System.out.println(user.getEmail() + " , " + user.getUid());
            } else {
                System.out.println("user not found");
            }
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
    }

    public void userByPhoneNumber(String phoneNumber) {

        try {
            UserRecord user = firebaseAuth.getUserByPhoneNumber(phoneNumber);
            if (user != null) {
                System.out.println(user.getPhoneNumber() + " , " + user.getUid());
            } else {
                System.out.println("user not found");
            }
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
    }


}
