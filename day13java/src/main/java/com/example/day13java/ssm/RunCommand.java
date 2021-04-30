package com.example.day13java.ssm;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.model.SendCommandRequest;
import com.amazonaws.services.simplesystemsmanagement.model.SendCommandResult;
import com.example.day13java.AwsHelper.AwsClientHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunCommand extends AwsClientHelper {

    private final AWSSimpleSystemsManagement awsSimpleSystemsManagement;
    private final RunCommandRequest request;

    public RunCommand(RunCommandRequest request) {
        awsSimpleSystemsManagement = awsSimpleSystemsManagement();
        this.request = request;
    }

    public void call() {
        log.debug("entered method ");

        SendCommandRequest sendCommandRequest = new SendCommandRequest();
        sendCommandRequest.setInstanceIds(request.getInstanceIds());
        sendCommandRequest.setDocumentName(request.getDocumentName());

        String status = "";
        String commandId = "";
        try {
            SendCommandResult sendCommandResult = awsSimpleSystemsManagement.sendCommand(sendCommandRequest);
            status = sendCommandResult.getCommand().getStatus();
            commandId = sendCommandResult.getCommand().getCommandId();

            log.debug("Command ID {} Status {} ", commandId, status);
        } catch (Exception e) {
            log.error("failed to Run Command ", e);
        }

        log.debug("exit from method ");
    }
}
