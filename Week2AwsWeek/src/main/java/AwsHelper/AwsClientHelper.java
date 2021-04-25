package AwsHelper;

import com.amazonaws.services.ec2.AmazonEC2;

public abstract class AwsClientHelper {

    protected AmazonEC2 amazonEC2() throws Exception {
        return AwsClientSessionManager.amazonEC2();
    }

}