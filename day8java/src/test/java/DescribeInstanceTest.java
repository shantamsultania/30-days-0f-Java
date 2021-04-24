import com.amazonaws.services.ec2.model.Instance;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DescribeInstanceTest extends TestCase {


    @Test
    public void testDescribeInstance() throws Exception {
        DescribeInstance describeInstance = new DescribeInstance();
        List<Instance> instances = describeInstance.call();
    }
}