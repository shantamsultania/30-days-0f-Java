package com.example.day12java.CloudFormations;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.DescribeStacksRequest;
import com.amazonaws.services.cloudformation.model.DescribeStacksResult;
import com.amazonaws.services.cloudformation.model.Stack;
import com.example.day12java.AwsHelper.AwsClientHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class DescribeStacks extends AwsClientHelper {

    private final AmazonCloudFormation amazonCloudFormation;
    private final DescribeStackRequest request;

    public DescribeStacks(DescribeStackRequest request) throws Exception {
        amazonCloudFormation = amazonCloudFormation();
        this.request = request;
    }

    public List<Stack> call() throws Exception {
        log.debug("entered method ");

        DescribeStacksRequest callRequest = new DescribeStacksRequest();
        Optional<String> name = Optional.ofNullable(request.getStackName());
        if (name.isPresent()) {
            callRequest.setStackName(request.getStackName());
        }
        log.debug("callRequest {}", callRequest);
        List<Stack> stacks = new ArrayList<>();

        try {

            DescribeStacksResult describeStacksResult = amazonCloudFormation.describeStacks(callRequest);

            log.debug("describe Stack Result  {}", describeStacksResult);
            stacks = describeStacksResult.getStacks();

            log.debug("exited the method with stacks = {} ", stacks);

        } catch (Exception e) {
            log.error("error while describing Stack ", e);
            throw new Exception(e);
        }
        log.debug("exited method ");
        return stacks;
    }
}
