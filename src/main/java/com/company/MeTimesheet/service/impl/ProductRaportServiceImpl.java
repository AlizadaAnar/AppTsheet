package com.company.MeTimesheet.service.impl;

import com.company.MeTimesheet.entity.ProductRaport;
import com.company.MeTimesheet.repository.ProductRaportRepository;
import com.company.MeTimesheet.service.ProductRaportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRaportServiceImpl implements ProductRaportService {

    private final ProductRaportRepository repository;

    public ProductRaportServiceImpl(ProductRaportRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public List<ProductRaport> getAllProductRapor() {
        return repository.findAll();
    }

    @Override
    public ProductRaport saveProductRaport(ProductRaport raport) {
        return repository.save(raport);
    }

    @Override
    public ProductRaport updatedProductRaport(Long id, ProductRaport raport) {
        ProductRaport productRaport = repository.findById(id).get();
        productRaport.setProductInTime(productRaport.getProductInTime());
        productRaport.setPriductQuantity(productRaport.getPriductQuantity());
        return repository.save(productRaport);
    }

    @Override
    public ProductRaport getProductRaportById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteProductRaportById(Long id) {
        repository.deleteById(id);
    }
}
