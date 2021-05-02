package com.example.day16java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClass {


    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/createuser/{email}/{password}")
    public void createUSerEP(@PathVariable String email, @PathVariable String password) {
        firebaseService.createUserWithEmailPassword(email, password);
    }

    @GetMapping("/createuser/{ph}")
    public void createUSerP(@PathVariable String ph) {
        firebaseService.createUserWithPhoneNumber(ph);
    }

    @GetMapping("/generateVerificationlink/{email}")
    public void verify(@PathVariable String email) {
        firebaseService.verifyEmail(email);
    }

    @GetMapping("/checkexistuserwithemail/{email}")
    public void existsEmail(@PathVariable String email) {
        firebaseService.userByEmail(email);
    }

    @GetMapping("/checkexistuserwithphonenumber/{phone}")
    public void existsphone(@PathVariable String phone) {
        firebaseService.userByPhoneNumber(phone);
    }

}
