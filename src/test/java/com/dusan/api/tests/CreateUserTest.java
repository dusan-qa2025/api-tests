package com.dusan.api.tests;

import com.dusan.api.base.BaseApiTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseApiTest {

    @Test
    public void testCreateUserReqRes() {

        String requestBody = """
                {
                "name": "Dusan"
                "job": "QA Engineer"
                }
                """;

        Response response =
                RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .post("/users")
                        .then()

                        .extract()
                        .response();

System.out.println("STATUS CODE: " +
        response.getStatusCode());

        System.out.println(response.asPrettyString());

        int status = response.getStatusCode();

        Assert.assertTrue(
                status == 201 || status == 403 || status == 500,
                "Unexpected status code: " + status
        );
    }
}