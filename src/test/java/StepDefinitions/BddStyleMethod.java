package StepDefinitions;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class BddStyleMethod {

    public static void simpleGetPostMethodBDD(String postNumber){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s",postNumber)).
                then().body("author", is("typicode"));
    }

    public static void checkContainsCollection(){
        given().contentType(ContentType.JSON).
                when().get("http://localhost:3000/posts/").
                then().body("author", containsInAnyOrder("typicode","typicode","typicode","typicode")).statusCode(200);
    }

    public static void performGetWithPathParameter() {
        given().contentType(ContentType.JSON).
                with().pathParam("post", 3).
                when().get("http://localhost:3000/posts/{post}").
                then().body("author", containsString("typicode")).statusCode(200);
    }
    public static void performGetWithQueryParameter() {
        given().contentType(ContentType.JSON).
                queryParam("id", 2).
                when().get("http://localhost:3000/posts").
                then().body("title", contains("Venkata")).statusCode(200);
    }

    public static void performPostithBodyParameter() {

        HashMap<String,String> posting  = new HashMap<>();
        posting.put("id", "7");
        posting.put("title", "Mahitha");
        posting.put("author", "Manogna");
        System.out.println("Veera");
        given()
                .contentType(ContentType.JSON).
                with()
                .body(posting).
                when()
                .post("http://localhost:3000/posts").
                then()
                .body("title", Is.is("Mahitha"));
    }
}
