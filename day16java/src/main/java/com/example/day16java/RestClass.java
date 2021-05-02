package com.example.day16java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class RestClass {


    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/createuser/{email}/{password}")
    public void createUSerEP(@PathVariable String email,@PathVariable String password)
    {
        firebaseService.createUserWithEmailPassword(email, password);
    }

    @GetMapping("/createuser/{ph}")
    public void createUSerP(@PathVariable String ph)
    {
        firebaseService.createUserWithPhoneNumber(ph);
    }
    @GetMapping("/verify/{email}")
    public void verify(@PathVariable String email){
        firebaseService.verifyEmail(email);
    }

    @GetMapping("/existu/{email}")
    public void existsEmail(@PathVariable String email)
    {
        firebaseService.userByEmail(email);
    }

    @GetMapping("/exist/{phone}")
    public void existsphone(@PathVariable String phone)
    {
        firebaseService.userByPhoneNumber(phone);
    }



}
