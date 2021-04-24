import com.amazonaws.services.ec2.model.Volume;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DescribeVolumeTest extends TestCase {

    @Test
    public void testDescribeVolumes() throws Exception {
        DescribeVolume describeVolume = new DescribeVolume();
        List<Volume> volumes = describeVolume.call();
    }

}