package io.github.otavioyukio.foodfly.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String imageUrl;
    private String description;
    private Boolean isActive;
    private String category;

    public Product(String name, BigDecimal price, String imageUrl, String description, Boolean isActive, String category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.isActive = isActive;
        this.category = category;
    }
}
