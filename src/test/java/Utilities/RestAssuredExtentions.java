package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtentions {

    public static RequestSpecification Request;

    public RestAssuredExtentions(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        var spec = builder.build();
        Request = RestAssured.given().spec(spec);

    }

    public static ResponseOptions<Response>  GetOpsWithParams(String url , Map<String,String> pathParams) throws URISyntaxException  {
        Request.pathParams(pathParams);
        //Request.get(new URI(url));
        return Request.get(url);
    }

    public static ResponseOptions<Response> GetOps(String url )  {
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PostWithBodyAndPathParameter(String url, Map<String,String> pathParams,Map<String,String> body) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> PostWithBodyAndPathParameter(String url,Map<String,String> body) {
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url, Map<String, String> pathParams) {
        Request.pathParams(pathParams);
        return Request.delete(url);
    }
}
