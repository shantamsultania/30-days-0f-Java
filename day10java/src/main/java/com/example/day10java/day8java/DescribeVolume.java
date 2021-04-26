package com.example.day10java.day8java;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeVolumesRequest;
import com.amazonaws.services.ec2.model.DescribeVolumesResult;
import com.amazonaws.services.ec2.model.Volume;
import com.example.day10java.AwsHelper.AwsClientHelper;

import java.util.ArrayList;
import java.util.List;

public class DescribeVolume extends AwsClientHelper {

    private final AmazonEC2 amazonEC2;

    public DescribeVolume() throws Exception {
        amazonEC2 = amazonEC2();
    }

    public List<Volume> call() {

        List<Volume> volumeList = new ArrayList<>();
        DescribeVolumesRequest describeVolumesRequest = new DescribeVolumesRequest();
        describeVolumesRequest.setMaxResults(100);
        try {
            DescribeVolumesResult describeVolumesResult = amazonEC2.describeVolumes(describeVolumesRequest);
            volumeList = describeVolumesResult.getVolumes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return volumeList;
    }

}
