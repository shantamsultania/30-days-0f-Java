package com.example.day10java.day11java;

import com.amazonaws.services.ec2.model.Vpc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DescribeVpcTest {

    @Test
    public void testDescriveVpc() throws Exception {
        DescribeVpc describeVpc = new DescribeVpc();

        List<Vpc> call = describeVpc.call();

    }
}