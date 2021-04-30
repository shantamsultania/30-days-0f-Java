package com.example.day12java.restapi;

import java.util.List;

public interface AwsDao {

    String createStack(String name);

    List<String> getAllStacks(String name);
}
