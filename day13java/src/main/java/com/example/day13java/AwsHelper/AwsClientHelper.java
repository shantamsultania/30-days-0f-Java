package com.example.day13java.AwsHelper;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;

public abstract class AwsClientHelper {

    protected AmazonEC2 amazonEC2() {
        return AwsClientSessionManager.amazonEC2();
    }

    protected AWSSimpleSystemsManagement awsSimpleSystemsManagement()
    {
        return AwsClientSessionManager.awsSimpleSystemsManagement();
    }
}