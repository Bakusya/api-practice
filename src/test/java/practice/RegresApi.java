package practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class RegresApi {

    RequestSpecification request = RestAssured.given();


    @Before
    public void baseUri(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        request = RestAssured.given();
        request.accept(ContentType.JSON);
    }

    @Test
    public void deleteUser(){

        String userInfo = "{\n" +
                "            \"email\": \"test123@gmail.com\",\n" +
                "            \"first_name\": \"nurs@gmail.com\",\n" +
                "            \"last_name\": \"male\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                "        }";
    }
}
