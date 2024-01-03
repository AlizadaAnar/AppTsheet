package com.company.MeTimesheet.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_raport")
public class ProductRaport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_in_time")
    private String productInTime;

    @Column(name = "product_quantity")
    private String priductQuantity;

    public ProductRaport() {

    }

    public ProductRaport(Long id) {
        this.id = id;
    }

    public ProductRaport(Long id, String productInTime, String priductQuantity) {
        this.id = id;
        this.productInTime = productInTime;
        this.priductQuantity = priductQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductInTime() {
        return productInTime;
    }

    public void setProductInTime(String productInTime) {
        this.productInTime = productInTime;
    }

    public String getPriductQuantity() {
        return priductQuantity;
    }

    public void setPriductQuantity(String priductQuantity) {
        this.priductQuantity = priductQuantity;
    }

    @Override
    public String toString() {
        return "ProductRaport{" +
                "id=" + id +
                ", productInTime='" + productInTime + '\'' +
                ", priductQuantity='" + priductQuantity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductRaport that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getProductInTime(), that.getProductInTime()) && Objects.equals(getPriductQuantity(), that.getPriductQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductInTime(), getPriductQuantity());
    }
}
