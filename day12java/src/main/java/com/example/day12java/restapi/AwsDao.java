package com.example.day12java.restapi;

import com.amazonaws.services.cloudformation.model.Stack;

import java.util.List;

public interface AwsDao {

    public String createStack(String name);
    public List<String> getAllStacks(String name);
}
