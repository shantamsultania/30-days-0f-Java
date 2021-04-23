package Api;

import junit.framework.TestCase;
import org.junit.Test;

public class RestApiTest extends TestCase {

    @Test
    public void test1()
    {
        RestApi restApi = new RestApi();
//        restApi.getDataModelList();
        restApi.addDataModel();
    }
}