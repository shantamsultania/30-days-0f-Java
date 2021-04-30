package com.example.day12java.CloudFormations;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.example.day12java.AwsHelper.AwsClientHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class CreateStack extends AwsClientHelper {

    private final AmazonCloudFormation amazonCloudFormation;

    private final CreateStacksRequest request;

    public CreateStack(CreateStacksRequest request) throws Exception {
        amazonCloudFormation = amazonCloudFormation();
        this.request = request;
    }

    public String call() {
        com.amazonaws.services.cloudformation.model.CreateStackRequest callRequest =
                new com.amazonaws.services.cloudformation.model.CreateStackRequest();
        callRequest.setStackName(request.getStackName());
        Optional<String> url = Optional.ofNullable(request.getTemplateUrl());
        if (url.isPresent())
        {
            callRequest.setTemplateURL(request.getTemplateUrl());
        }else{
            callRequest.setTemplateBody(request.getTemplateBody());
        }

        Optional<Map<String, String>> parameters = Optional.ofNullable(request.getParameterMap());

        if (parameters.isPresent()) {
            List<Parameter> parameterList = new ArrayList<>();
            for (Map.Entry<String, String> entry : request.getParameterMap().entrySet()) {
                Parameter parameter = new Parameter();
                parameter.setParameterKey(entry.getKey());
                parameter.setParameterValue(entry.getValue());
                parameterList.add(parameter);
            }
            callRequest.setParameters(parameterList);
        }
        log.debug("callRequest = {} ", callRequest);

        CreateStackResult createStackResult = amazonCloudFormation.createStack(callRequest);
        log.debug("createStackResult = {}", createStackResult);

        String stackId = createStackResult.getStackId();
        log.debug("stackId = {}", stackId);

        return stackId;
    }

}
