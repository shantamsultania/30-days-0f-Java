package com.example.day12java.restapi;

import com.amazonaws.services.cloudformation.model.Stack;
import com.example.day12java.CloudFormations.CreateStack;
import com.example.day12java.CloudFormations.CreateStacksRequest;
import com.example.day12java.CloudFormations.DescribeStackRequest;
import com.example.day12java.CloudFormations.DescribeStacks;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class AwsDaoImp implements AwsDao {


    @Override
    public String createStack(String name) {

        CreateStacksRequest createStacksRequest = new CreateStacksRequest();
        createStacksRequest.setStackName(name);
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

        CreateStack createStack = null;
        try {
            createStack = new CreateStack(createStacksRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createStack.call();
    }

    @Override
    public List<String> getAllStacks(String name) {

        DescribeStackRequest describeStackRequest = new DescribeStackRequest();
        if(!name.equals("xx"))
        {
         describeStackRequest.setStackName(name);
        }
        List<String> stack = new ArrayList<>();
        try {
          DescribeStacks describeStacks = new DescribeStacks(describeStackRequest);
            List<Stack> call = describeStacks.call();
            for (Stack currentStack : call) {
                stack.add(currentStack.getStackName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stack;
    }


}
