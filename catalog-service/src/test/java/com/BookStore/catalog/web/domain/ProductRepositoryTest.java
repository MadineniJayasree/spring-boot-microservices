package com.BookStore.catalog.web.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest(
        properties = {"spring.test.database.replace=none", "spring.datasource.url=jdbc:mysql://localhost:3306/testdb"})
// @Import(ContainersConfig.class)
@Sql("/test-data.sql")
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldGetAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        assertThat(products).hasSize(20);
    }

    @Test
    void shouldGetProductByCode() {
        ProductEntity product = productRepository.findByCode("B003").orElseThrow();
        assertThat(product.getCode()).isEqualTo("B003");
        assertThat(product.getName()).isEqualTo("The Great Gatsby");
        assertThat(product.getDescription()).isEqualTo("Novel by F. Scott Fitzgerald");
        assertThat(product.getPrice()).isEqualTo(new BigDecimal("9.99"));
    }

    @Test
    void shouldReturnEmptyWhenProductCodeNotExists() {
        assertThat(productRepository.findByCode("invalid_product_code")).isEmpty();
    }
}
