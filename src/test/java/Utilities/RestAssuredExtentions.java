package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtentions {

    public static RequestSpecification Request;
    public RestAssuredExtentions(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://localhost:3000");
        requestSpecBuilder.setContentType(ContentType.JSON);
        var reqSpec = requestSpecBuilder.build();
        Request = RestAssured.given().spec(reqSpec);
    }

    public static void getOperationWithParaets(String url , Map<String,String> pathParams) throws URISyntaxException {
        Request.pathParams(pathParams);
        Request.get(new URI(url));
    }
}
