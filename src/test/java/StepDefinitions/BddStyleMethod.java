package StepDefinitions;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

public class BddStyleMethod {

    public static void simpleGetPostMethodBDD(String postNumber){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s",postNumber)).
                then().body("author", is("typicode"));
    }

    public static void checkContainsCollection(){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/")).
                then().body("author", containsInAnyOrder("typicode")).statusCode(200);
    }
}
