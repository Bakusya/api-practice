package practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestAssuredDemo {


    RequestSpecification request = RestAssured.given();


    @Before
    public void baseUri(){
        RestAssured.baseURI = "https://gorest.co.in/public/v1";
        request = RestAssured.given();
        request.accept(ContentType.JSON);
    }

    @Test
    public void getAllUsers() {
        Response response = request.get("/users");
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
    }

    @Test

    public void createNewUser() {
        String userInfoJson = "{\n" +
                "            \"name\": \"Nursultan\",\n" +
                "            \"email\": \"nurs@gmail.com\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"status\": \"active\"\n" +
                "        }";
        Response response = request
                .given()
                .header("Authorization","Bearer 9bb228962a5436bc9ac217ad3511d60faa102226c6a7b8f46b24690095d0f249")
                .contentType(ContentType.JSON)
                .body(userInfoJson)
                .post("/users");
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(201,response.getStatusCode());
    }

    @Test
    public void findUserByQueryParam(){
        Response response = request
                .given()
                .contentType(ContentType.JSON)
                .queryParam("name","Nursultan")
                .get("/users");
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.getStatusCode());
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test
    public void updateUser(){

        String userInfoJson = "{\n" +
                "            \"name\": \"Baha\",\n" +
                "            \"email\": \"baha@gmail.com\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"status\": \"active\"\n" +
                "        }";

        Response response = request
                .given()
                .header("Authorization","Bearer 9bb228962a5436bc9ac217ad3511d60faa102226c6a7b8f46b24690095d0f249")
                .contentType(ContentType.JSON)
                .body(userInfoJson)
                .patch("/users/2102");
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(200,response.getStatusCode());

    }

       
       
       
    
}
