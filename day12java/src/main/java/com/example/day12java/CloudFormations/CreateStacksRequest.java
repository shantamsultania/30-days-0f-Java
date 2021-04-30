package com.example.day12java.CloudFormations;

import lombok.Data;

import java.util.Map;

@Data
public class CreateStacksRequest {

    private String templateBody;
    private String stackName;
    private Map<String, String> parameterMap;
    private String templateUrl;


}
