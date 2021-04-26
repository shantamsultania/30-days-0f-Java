package com.example.day10java.day9Java;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.example.day10java.AwsHelper.AwsClientHelper;

import java.util.ArrayList;
import java.util.List;

public class CreateInstance extends AwsClientHelper {

    private final AmazonEC2 amazonEC2;
    private final CreateInstanceRequest createInstanceRequest;

    CreateInstance(CreateInstanceRequest request) throws Exception {
        amazonEC2 = amazonEC2();
        createInstanceRequest = request;
    }

    public List<Instance> call() {
        RunInstancesRequest runInstancesRequest = new RunInstancesRequest();
        runInstancesRequest.setMinCount(1);
        runInstancesRequest.setMaxCount(1);
        runInstancesRequest.setImageId(createInstanceRequest.getImageId());
        runInstancesRequest.setInstanceType(createInstanceRequest.getInstanceType());
        List<Instance> instances = new ArrayList<>();
        try {
            RunInstancesResult runInstancesResult = amazonEC2.runInstances(runInstancesRequest);
            instances = runInstancesResult.getReservation().getInstances();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instances;
    }
}
