package com.inventra.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sku")
    private String sku;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "min_stock_level")
    private Integer minStockLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProductStatus status;

    public Product() {
    }

    public Product(String name, String sku, Double unitPrice, Integer stockQuantity, Integer minStockLevel, ProductStatus status) {
        this.name = name;
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.minStockLevel = minStockLevel;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public Integer getMinStockLevel() {
        return minStockLevel;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setMinStockLevel(Integer minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}