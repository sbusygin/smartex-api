package test;

import api.ApiRequest;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected ApiRequest apiRequest;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        apiRequest = new ApiRequest();
        softAssert = new SoftAssert();
    }
}
