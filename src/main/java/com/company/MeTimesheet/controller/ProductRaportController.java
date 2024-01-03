package com.company.MeTimesheet.controller;


import com.company.MeTimesheet.entity.ProductRaport;
import com.company.MeTimesheet.entity.Workers;
import com.company.MeTimesheet.service.ProductRaportService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/v1")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class ProductRaportController {

    private final ProductRaportService productRaportService;

    public ProductRaportController(ProductRaportService productRaportService) {
        super();
        this.productRaportService = productRaportService;
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping(value = "/raport", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductRaport> listProductRaports() {
        return productRaportService.getAllProductRapor();
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @PostMapping("/raport")
    public void saveProductRaports(@RequestBody ProductRaport productRaport) {
        productRaportService.saveProductRaport(productRaport);
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @PutMapping("/raport/{wId}")
    public ProductRaport updateProductRaport(@PathVariable Long wId, @RequestBody ProductRaport productRaportRequest) {
        return productRaportService.updatedProductRaport(wId, productRaportRequest);
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping("/raport/{id}")
    public ProductRaport findProductraportById(@PathVariable long id) {
        return productRaportService.getProductRaportById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @DeleteMapping("/raport/{id}")
    public void DELETE(@PathVariable Long id) {
        productRaportService.deleteProductRaportById(id);
    }

}
