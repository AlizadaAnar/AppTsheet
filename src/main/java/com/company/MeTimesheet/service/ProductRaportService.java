package com.company.MeTimesheet.service;

import com.company.MeTimesheet.entity.ProductRaport;
import com.company.MeTimesheet.entity.Workers;

import java.util.List;

public interface ProductRaportService {

    List<ProductRaport> getAllProductRapor();

    ProductRaport saveProductRaport(ProductRaport raport);

    ProductRaport updatedProductRaport(Long id, ProductRaport raport);

    ProductRaport getProductRaportById(Long id);

    void deleteProductRaportById(Long id);

}
