package com.test.backend;

import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestBackend {

    @Before
    public void init() {
        RestAssured.baseURI = "https://api.openbrewerydb.org";
        RestAssured.basePath = "/breweries/";
        RestAssured.filters(new ResponseLoggingFilter());
    }

    @Test
    public void testResponse() {

        String response = given()
                .get("autocomplete?query=lagunitas").then().extract().asString();

        List<Map> elements = JsonPath.from(response).get("findAll { elements -> elements.name == 'Lagunitas Brewing Co'}");

        String details = "";
        for (int i = 0; i < elements.size(); i++) {
            details = given()
                    .get((String) elements.get(i).get("id")).then().extract().asString();
            if (JsonPath.from(details).get("state == 'California'")) {

                Assert.assertEquals(JsonPath.from(details).getString("name"), "Lagunitas Brewing Co");
                Assert.assertEquals(JsonPath.from(details).getString("street"), "1280 N McDowell Blvd");
                Assert.assertEquals(JsonPath.from(details).getString("phone"), "7077694495");

            }
        }
    }

}
