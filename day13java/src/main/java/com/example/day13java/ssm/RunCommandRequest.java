package com.example.day13java.ssm;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class RunCommandRequest {

    private List<String> instanceIds;
    private String documentName;
    private HashMap<String, List<String>> Parameter;

}
