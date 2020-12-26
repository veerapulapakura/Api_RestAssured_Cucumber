package StepDefinitions;

import Utilities.RestAssuredExtentions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;

import java.util.HashMap;
import java.util.Map;

public class PutSteps {

    @And("^I Perform PUT operation for \"([^\"]*)\"$")
    public void iPerformPUTOperationFor(String url, DataTable table) throws Throwable {
        {
            var data = table.raw();

            Map<String, String> body = new HashMap<>();
            body.put("id", data.get(1).get(0));
            body.put("title", data.get(1).get(1));
            body.put("author", data.get(1).get(2));

            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("postid", data.get(1).get(0));

            //Perform post operation
            RestAssuredExtentions.PUTOpsWithBodyAndPathParams(url, body, pathParams);

        }
    }
}
