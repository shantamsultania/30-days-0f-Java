package com.example.day10java.day8java;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.Image;
import com.example.day10java.AwsHelper.AwsClientHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescribeImages extends AwsClientHelper {

    private AmazonEC2 amazonEC2;
    public DescribeImages() throws Exception {
        amazonEC2 = amazonEC2();
    }

    public List<Image> call()
    {
        List<Image> imageList = new ArrayList<>();

        DescribeImagesRequest callRequest = new DescribeImagesRequest();
        callRequest.setOwners(Collections.singleton("self"));
        try {
            DescribeImagesResult describeImagesResult = amazonEC2.describeImages(callRequest);
            imageList = describeImagesResult.getImages();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return imageList;
    }
}
