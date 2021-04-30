package com.example.day13java.restapi;

import com.example.day13java.ssm.RunCommand;
import com.example.day13java.ssm.RunCommandRequest;

public class AwsDaoImp implements AwsDao {


    @Override
    public boolean runCommand() {

        RunCommandRequest request = new RunCommandRequest();
        RunCommand runCommand = new RunCommand(request);
        runCommand.call();
        return true;
    }
}
