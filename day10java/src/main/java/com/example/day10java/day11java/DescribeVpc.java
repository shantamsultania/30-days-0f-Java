package com.example.day10java.day11java;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeVpcsRequest;
import com.amazonaws.services.ec2.model.DescribeVpcsResult;
import com.amazonaws.services.ec2.model.Vpc;
import com.example.day10java.AwsHelper.AwsClientHelper;

import java.util.ArrayList;
import java.util.List;

public class DescribeVpc extends AwsClientHelper {

    private AmazonEC2 amazonEC2;

    public DescribeVpc() throws Exception {
        amazonEC2 = amazonEC2();
    }

    public List<Vpc> call()
    {
        List<Vpc> vpcs = new ArrayList<>();

        DescribeVpcsRequest describeVpcsRequest = new DescribeVpcsRequest();
        describeVpcsRequest.setMaxResults(100);
        DescribeVpcsResult describeVpcsResult = amazonEC2.describeVpcs();
        vpcs = describeVpcsResult.getVpcs();
        return vpcs;
    }

}
