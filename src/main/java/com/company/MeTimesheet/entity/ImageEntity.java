package com.company.MeTimesheet.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "image_table")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "image_name", nullable = false)
    private String imageName;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Lob
    @Column(name = "image_data", length = 100000)
    private byte[] imageData;

    // Constructors, Getters, and Setters

    public ImageEntity() {

    }

    public ImageEntity(Long imageId) {
        this.imageId = imageId;
    }

    public ImageEntity(Long imageId, String imageName, int productQuantity, byte[] imageData) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.productQuantity = productQuantity;
        this.imageData = imageData;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageEntity that)) return false;
        return getProductQuantity() == that.getProductQuantity() && Objects.equals(getImageId(), that.getImageId()) && Objects.equals(getImageName(), that.getImageName()) && Arrays.equals(getImageData(), that.getImageData());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getImageId(), getImageName(), getProductQuantity());
        result = 31 * result + Arrays.hashCode(getImageData());
        return result;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "imageId=" + imageId +
                ", imageName='" + imageName + '\'' +
                ", productQuantity=" + productQuantity +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }
}
