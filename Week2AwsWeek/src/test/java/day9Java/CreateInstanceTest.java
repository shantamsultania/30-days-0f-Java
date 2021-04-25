package day9Java;

import junit.framework.TestCase;
import org.junit.Test;

public class CreateInstanceTest extends TestCase {

    @Test
    public void testCreateInstance() throws Exception {
        CreateInstanceRequest createInstanceRequest = new CreateInstanceRequest();
        createInstanceRequest.setImageId("ami-0376ab546463198de");
        createInstanceRequest.setInstanceType("t2.micro");

        CreateInstance createInstance= new CreateInstance(createInstanceRequest);
        createInstance.call();
    }

}