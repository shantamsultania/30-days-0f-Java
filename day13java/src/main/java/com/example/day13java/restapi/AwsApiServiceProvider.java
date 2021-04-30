package com.example.day13java.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsApiServiceProvider {

    private final AwsDao awsDao = new AwsDaoImp();


    @GetMapping("/runCommand")
    public boolean runCommand()
    {
        return awsDao.runCommand();

    }
}
