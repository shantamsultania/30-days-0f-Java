package com.example.day12java.AwsHelper;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;

public class AwsClientSessionManager {

    private static final AwsCredential awsCredential = new AwsCredential();

    public static synchronized AmazonEC2 amazonEC2() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials
                (awsCredential.getAccessKey()
                        , awsCredential.getSecretKey());

        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(basicAWSCredentials);
        ClientConfiguration configuration = new ClientConfiguration().withMaxConnections(100);

        AmazonEC2 amazonEC2 = AmazonEC2ClientBuilder.standard().withCredentials(awsStaticCredentialsProvider).withRegion("us-east-1").withClientConfiguration(configuration).build();

        return amazonEC2;

    }


    public static synchronized AmazonCloudFormation amazonCloudFormation() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials
                (awsCredential.getAccessKey()
                        , awsCredential.getSecretKey());

        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(basicAWSCredentials);
        ClientConfiguration configuration = new ClientConfiguration().withMaxConnections(100);
        AmazonCloudFormation amazonCloudFormation = AmazonCloudFormationClientBuilder.standard().withCredentials(awsStaticCredentialsProvider).withRegion("us-east-1").withClientConfiguration(configuration).build();

        return amazonCloudFormation;

    }

    public static synchronized AWSSimpleSystemsManagement awsSimpleSystemsManagement() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials
                (awsCredential.getAccessKey()
                        , awsCredential.getSecretKey());

        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(basicAWSCredentials);
        ClientConfiguration configuration = new ClientConfiguration().withMaxConnections(100);
        AWSSimpleSystemsManagement awsSimpleSystemsManagement = AWSSimpleSystemsManagementClientBuilder.standard().withCredentials(awsStaticCredentialsProvider).build();
        return awsSimpleSystemsManagement;

    }



}
