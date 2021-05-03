package com.example.day16java;

import com.example.day16java.day16.FirebaseAuthenticationDemo;
import com.example.day16java.day17.FirebaseRealTimeDatabaseDemo;
import com.example.day16java.day17.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApiDemo {


    @Autowired
    FirebaseAuthenticationDemo firebaseAuthenticationDemo;

    @Autowired
    FirebaseRealTimeDatabaseDemo firebaseRealTimeDatabaseDemo;

    @GetMapping("/senddata")
    public List<User> sendData() {
        return firebaseRealTimeDatabaseDemo.getDataFromFirebase();
    }

    @GetMapping("/createuser/{email}/{password}")
    public void createUSerEP(@PathVariable String email, @PathVariable String password) {
        firebaseAuthenticationDemo.createUserWithEmailPassword(email, password);
    }

    @GetMapping("/createuser/{ph}")
    public void createUSerP(@PathVariable String ph) {
        firebaseAuthenticationDemo.createUserWithPhoneNumber(ph);
    }

    @GetMapping("/generateVerificationlink/{email}")
    public void verify(@PathVariable String email) {
        firebaseAuthenticationDemo.verifyEmail(email);
    }

    @GetMapping("/checkexistuserwithemail/{email}")
    public void existsEmail(@PathVariable String email) {
        firebaseAuthenticationDemo.userByEmail(email);
    }

    @GetMapping("/checkexistuserwithphonenumber/{phone}")
    public void existsphone(@PathVariable String phone) {
        firebaseAuthenticationDemo.userByPhoneNumber(phone);
    }

}
