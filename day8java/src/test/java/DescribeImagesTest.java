import com.amazonaws.services.ec2.model.Image;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DescribeImagesTest extends TestCase {

    @Test
    public void testDescribeImages() throws Exception {
        DescribeImages describeImages = new DescribeImages();
        List<Image> images = describeImages.call();
    }

}