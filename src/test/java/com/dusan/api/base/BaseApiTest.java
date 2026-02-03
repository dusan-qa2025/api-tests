package com.dusan.api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";

    }
}
