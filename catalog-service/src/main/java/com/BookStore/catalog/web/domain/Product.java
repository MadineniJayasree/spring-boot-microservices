package com.BookStore.catalog.web.domain;

import java.math.BigDecimal;

public record Product<T>(String code, String name, String description, String imageUrl, BigDecimal price) {}
