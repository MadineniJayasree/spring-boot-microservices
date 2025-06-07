package com.BookStore.catalog.web.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import com.BookStore.catalog.web.AbstractIT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

@Sql("/test-data.sql")
public class ProductControllerTest extends AbstractIT {

    @Test
    void shouldReturnProducts() {
        Response response = given().contentType(ContentType.JSON).when().get("/api/products");
        response.then().log().body();
        response.then()
                .statusCode(200)
                .body("data", hasSize(10))
                .body("totalElements", is(20))
                .body("pageNumber", is(1))
                .body("totalPage", is(2))
                .body("isFirst", is(true))
                .body("isLast", is(false))
                .body("hasNext", is(true))
                .body("hasPrevious", is(false));
    }
}
