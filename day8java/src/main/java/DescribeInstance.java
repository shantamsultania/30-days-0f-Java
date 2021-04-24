import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class DescribeInstance extends AwsClientHelper {

    private final AmazonEC2 amazonEC2;

    public DescribeInstance() throws Exception {
        amazonEC2 = amazonEC2();
    }

    public List<Instance> call() throws Exception {

        List<Instance> instanceList = new ArrayList<>();

        DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest();
        describeInstancesRequest.setMaxResults(100);
        try {
            DescribeInstancesResult describeInstancesResult = amazonEC2.describeInstances();
            for (Reservation reservation : describeInstancesResult.getReservations()) {
                instanceList.addAll(reservation.getInstances());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instanceList;
    }

}
