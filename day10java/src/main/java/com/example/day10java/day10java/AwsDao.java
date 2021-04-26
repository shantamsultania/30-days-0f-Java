package com.example.day10java.day10java;

import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Snapshot;
import com.amazonaws.services.ec2.model.Volume;

import java.util.List;

public interface AwsDao {

    List<Instance> getAllInstance() throws Exception;

    List<Image> getAllImages() throws Exception;

    List<Snapshot> getAllSnapShots() throws Exception;

    List<Volume> getAllVolumes() throws Exception;

}
