package StepDefinitions;

import Utilities.RestAssuredExtentions;
import cucumber.api.java.Before;
public class TestInitialise {

    @Before
    public void TestSetUp(){
        RestAssuredExtentions restAssuredExtentions = new RestAssuredExtentions();
    }

}
