package com.dusan.api.tests;

import com.dusan.api.base.BaseApiTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersTest extends BaseApiTest {

    @Test
    public void testGetUsers(){

        Response response = RestAssured
                .given()
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0")
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .extract()
                .response();

        System.out.println("STATUS CODE: " +
                response.getStatusCode());
        System.out.println("RESPONSE BODY: ");
        System.out.println(response.asPrettyString());


        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertEquals(response.jsonPath().getString("username"),
                "Bret");

    }

    @Test
    public void testGetUserNotFound(){

        Response response =
                RestAssured
                        .given()
                        .when()
                        .get("https://jsonplaceholder.typicode.com/users/9999")
                        .then()
                        .extract()
                        .response();

        System.out.println("STATUS CODE: " +
                response.getStatusCode());
        System.out.println("RESPONSE BODY: ");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(),404);
    }
}
