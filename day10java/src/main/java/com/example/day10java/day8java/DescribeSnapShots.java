package com.example.day10java.day8java;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeSnapshotsRequest;
import com.amazonaws.services.ec2.model.DescribeSnapshotsResult;
import com.amazonaws.services.ec2.model.Snapshot;
import com.example.day10java.AwsHelper.AwsClientHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DescribeSnapShots extends AwsClientHelper {

    private AmazonEC2 amazonEC2;
    public DescribeSnapShots() throws Exception {
        amazonEC2 = amazonEC2();
    }

    public List<Snapshot> call()
    {
        List<Snapshot> snapshots = new ArrayList<>();
        DescribeSnapshotsRequest describeSnapshotsRequest = new DescribeSnapshotsRequest();
        describeSnapshotsRequest.setOwnerIds(Arrays.asList("self"));
        try {
            DescribeSnapshotsResult describeSnapshotsResult = amazonEC2.describeSnapshots(describeSnapshotsRequest);
            snapshots = describeSnapshotsResult.getSnapshots();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return snapshots;
    }
}
