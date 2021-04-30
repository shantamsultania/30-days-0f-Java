package com.example.day12java.CloudFormations;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class CreateStackTest {

    @Test
    public void testCreateStack() throws Exception {
        CreateStacksRequest createStacksRequest = new CreateStacksRequest();
        createStacksRequest.setStackName("testCreate");
        String location = "C:\\Users\\hp\\Desktop\\ec1.yaml";

        StringBuilder templateBody = new StringBuilder();
        try {
            InputStream stream = new FileInputStream(location);
            Reader reader = new InputStreamReader(stream);
            int data = reader.read();
            while (data != -1) {
                templateBody.append((char) data);
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        createStacksRequest.setTemplateBody(templateBody.toString());

        CreateStack createStack = new CreateStack(createStacksRequest);
        createStack.call();
    }
}