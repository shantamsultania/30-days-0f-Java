package com.example.day12java.AwsHelper;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.ec2.AmazonEC2;

public abstract class AwsClientHelper {

    protected AmazonEC2 amazonEC2() throws Exception {
        return AwsClientSessionManager.amazonEC2();
    }

    protected AmazonCloudFormation amazonCloudFormation() throws Exception{
        return AwsClientSessionManager.amazonCloudFormation();
    }
}