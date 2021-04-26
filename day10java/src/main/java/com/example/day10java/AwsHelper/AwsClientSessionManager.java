package com.example.day10java.AwsHelper;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;

public class AwsClientSessionManager {

    private static AwsCredential awsCredential = new AwsCredential();

    public static synchronized AmazonEC2 amazonEC2()
    {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials
                (awsCredential.getAccessKey()
                ,awsCredential.getSecretKey());

        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(basicAWSCredentials);
        ClientConfiguration configuration = new ClientConfiguration().withMaxConnections(100);

        AmazonEC2 amazonEC2 = AmazonEC2ClientBuilder.standard().withCredentials(awsStaticCredentialsProvider).withRegion("us-east-1").withClientConfiguration(configuration).build();

        return amazonEC2;

    }

    public void testKeys()
    {
        System.out.println(awsCredential.getAccessKey());
        System.out.println(awsCredential.getSecretKey());
    }
}
