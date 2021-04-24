import com.amazonaws.services.ec2.model.Snapshot;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DescribeSnapShotsTest extends TestCase {

    @Test
    public void testDescribeSnapShots() throws Exception {
        DescribeSnapShots describeSnapShots = new DescribeSnapShots();
        List<Snapshot> snapshots = describeSnapShots.call();
    }
}