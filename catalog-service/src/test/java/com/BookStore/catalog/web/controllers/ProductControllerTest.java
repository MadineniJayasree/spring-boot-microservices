package com.BookStore.catalog.web.controllers;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.BookStore.catalog.web.AbstractIT;
import com.BookStore.catalog.web.domain.Product;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.math.BigDecimal;
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

    @Test
    void shouldGetProductByCode() {

        Product product = given().contentType(ContentType.JSON)
                .when()
                .get("/api/products/{code}", "B004")
                .then()
                .statusCode(200)
                .assertThat()
                .extract()
                .body()
                .as(Product.class);

        assertThat(product.code()).isEqualTo("B004");
        assertThat(product.name()).isEqualTo("Life of Pi");
        assertThat(product.description()).isEqualTo("Adventure fiction by Yann Martel");
        assertThat(product.price()).isEqualTo(new BigDecimal("11.99"));
    }

    @Test
    void shouldReturnNotFoundWhenProductCodeNotExists() {
        String code = "invalid_product_code";
        Response response2 = given().contentType(ContentType.JSON).when().get("/api/products/{code}", code);
        response2.then().log().body();
        response2
                .then()
                .statusCode(404)
                .body("status", is(404))
                .body("title", is("Product Not found"))
                .body("detail", is("product with code " + code + " not found"));
    }
}
