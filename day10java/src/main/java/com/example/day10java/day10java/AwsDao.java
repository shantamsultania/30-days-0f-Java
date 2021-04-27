package com.example.day10java.day10java;

import com.amazonaws.services.ec2.model.*;

import java.util.List;

public interface AwsDao {

    List<Instance> getAllInstance() throws Exception;

    List<Image> getAllImages() throws Exception;

    List<Snapshot> getAllSnapShots() throws Exception;

    List<Volume> getAllVolumes() throws Exception;

    List<Vpc> getAllVpc() throws Exception;

    List<InternetGateway> getAllIGW() throws Exception;

}
