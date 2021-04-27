package com.example.day10java.day10java;

import com.amazonaws.services.ec2.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AwsApiServiceProvider {

    private final AwsDao awsDao = new AwsDaoImp();

    @GetMapping("/getec2")
    public List<Instance> showAllEc2() {
        List<Instance> instances = new ArrayList<>();
        try {
            instances = awsDao.getAllInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instances;
    }

    @GetMapping("/getimages")
    public List<Image> showAllImages() {
        List<Image> images = new ArrayList<>();
        try {
            images = awsDao.getAllImages();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return images;
    }

    @GetMapping("/getvolumes")
    public List<Volume> showAllVolumes() {
        List<Volume> volumes = new ArrayList<>();
        try {
            volumes = awsDao.getAllVolumes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return volumes;
    }

    @GetMapping("/getsnapshots")
    public List<Snapshot> showAllSnapshots() {
        List<Snapshot> snapshots = new ArrayList<>();
        try {
            snapshots = awsDao.getAllSnapShots();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snapshots;
    }

    @GetMapping("/getvpc")
    public List<Vpc> showAllVpc()
    {
        List<Vpc> vpcs = new ArrayList<>();
        try {
            vpcs = awsDao.getAllVpc();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vpcs;
    }

    @GetMapping("/getgateway")
    public List<InternetGateway> showAllInternetGateWay()
    {
        List<InternetGateway> internetGatewayList = new ArrayList<>();
        try {
            internetGatewayList = awsDao.getAllIGW();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return internetGatewayList;
    }
}
