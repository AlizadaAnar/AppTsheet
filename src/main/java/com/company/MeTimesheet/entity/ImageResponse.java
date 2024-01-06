package com.company.MeTimesheet.entity;

import java.util.Objects;

public class ImageResponse {

    private Long id;
    private String imageName;
    private int productQuantity;
    private String imageUrl;

    // Getters and Setters

    public ImageResponse() {

    }

    public ImageResponse(Long id) {
        this.id = id;
    }

    public ImageResponse(Long id, String imageName, int productQuantity, String imageUrl) {
        this.id = id;
        this.imageName = imageName;
        this.productQuantity = productQuantity;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageResponse that)) return false;
        return getProductQuantity() == that.getProductQuantity() && Objects.equals(getId(), that.getId()) && Objects.equals(getImageName(), that.getImageName()) && Objects.equals(getImageUrl(), that.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getImageName(), getProductQuantity(), getImageUrl());
    }

    @Override
    public String toString() {
        return "ImageResponse{" +
                "id=" + id +
                ", imageName='" + imageName + '\'' +
                ", productQuantity=" + productQuantity +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
