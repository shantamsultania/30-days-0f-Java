package com.example.day10java.day11java;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInternetGatewaysRequest;
import com.amazonaws.services.ec2.model.DescribeInternetGatewaysResult;
import com.amazonaws.services.ec2.model.InternetGateway;
import com.example.day10java.AwsHelper.AwsClientHelper;

import java.util.ArrayList;
import java.util.List;

public class DescribeNetWorkGateWay extends AwsClientHelper {

    private final AmazonEC2 amazonEC2;

    public DescribeNetWorkGateWay() throws Exception {
        amazonEC2 = amazonEC2();
    }

    public List<InternetGateway> call() {
        List<InternetGateway> internetGatewayList = new ArrayList<>();

        DescribeInternetGatewaysRequest describeInternetGatewaysRequest = new DescribeInternetGatewaysRequest();
        describeInternetGatewaysRequest.setMaxResults(100);
        DescribeInternetGatewaysResult describeInternetGatewaysResult = amazonEC2.describeInternetGateways();

        internetGatewayList = describeInternetGatewaysResult.getInternetGateways();
        return internetGatewayList;
    }


}
