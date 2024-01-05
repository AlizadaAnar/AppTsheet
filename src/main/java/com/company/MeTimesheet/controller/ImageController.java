package com.company.MeTimesheet.controller;

import com.company.MeTimesheet.repository.StorageRepository;
import com.company.MeTimesheet.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class ImageController {

    private final StorageService service;

    public ImageController(StorageService service) {
        super();
        this.service = service;
    }

    private StorageRepository repository;


    @CrossOrigin(origins = "http://localhost:5173/")
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }


    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping(value = "/{fileName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        byte[] imageData = service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(imageData);
    }

}
