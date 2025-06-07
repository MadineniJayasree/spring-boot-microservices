package com.BookStore.catalog.web.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Product code is required")
    private String code;

    @NotEmpty(message = "Product name is required")
    @Column(nullable = true)
    private String name;

    private String description;

    private String imageUrl;

    @NotNull(message = "Product price is required")
    @DecimalMin("0.1")
    @Column(nullable = false)
    private BigDecimal price;

    public ProductEntity() {}

    public ProductEntity(Long id, String code, String name, String description, String imageUrl, BigDecimal price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductEntity{" + "id="
                + id + ", code='"
                + code + '\'' + ", name='"
                + name + '\'' + ", description='"
                + description + '\'' + ", imageUrl='"
                + imageUrl + '\'' + ", price="
                + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity that)) return false;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getCode(), that.getCode())
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getDescription(), that.getDescription())
                && Objects.equals(getImageUrl(), that.getImageUrl())
                && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName(), getDescription(), getImageUrl(), getPrice());
    }

    public void setId(Long id) {
        this.id = id;
    }
}
