package com.BookStore.catalog.web.web.controllers;

import com.BookStore.catalog.web.domain.PagedResult;
import com.BookStore.catalog.web.domain.Product;
import com.BookStore.catalog.web.domain.ProductNotFoundException;
import com.BookStore.catalog.web.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> ProductByCode(@PathVariable("code") String code) {
        return productService
                .getProductsByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }
}
