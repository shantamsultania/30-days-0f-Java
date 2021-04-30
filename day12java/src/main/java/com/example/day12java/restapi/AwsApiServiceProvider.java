package com.example.day12java.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AwsApiServiceProvider {

    private final AwsDao awsDao = new AwsDaoImp();

    @GetMapping("/getstacks")
    public List<String> getStacks()
    {
        return awsDao.getAllStacks("xx");
    }

    @GetMapping("/createStacks")
    public String createStack()
    {
        return awsDao.createStack("shantam");
    }
}
