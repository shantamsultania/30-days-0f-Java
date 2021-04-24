import junit.framework.TestCase;
import org.junit.Test;

public class AwsClientSessionManagerTest extends TestCase {

    @Test
    public void tester() throws Exception {
        AwsClientSessionManager awsClientSessionManager = new AwsClientSessionManager();
        awsClientSessionManager.testKeys();
    }

}