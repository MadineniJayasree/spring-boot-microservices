package com.BookStoreProject.catalog_service.domain;

import java.math.BigDecimal;

public record Product<T>(
         String code,
         String name,
         String description,
         String imageUrl,
         BigDecimal price
){
}
