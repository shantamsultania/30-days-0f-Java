package com.example.day13java.ssm;

import org.junit.jupiter.api.Test;

import java.util.Collections;

class RunCommandTest {


    @Test
    public void testRunCommands() {

        RunCommandRequest runCommandRequest = new RunCommandRequest();
        runCommandRequest.setDocumentName("AWS-RunShellScript");
        runCommandRequest.setInstanceIds(Collections.singletonList("i-0d0f28eb0116311b9"));

        RunCommand runCommand = new RunCommand(runCommandRequest);
        runCommand.call();
    }
}