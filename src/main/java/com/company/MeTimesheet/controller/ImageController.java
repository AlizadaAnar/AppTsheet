package com.company.MeTimesheet.controller;

import com.company.MeTimesheet.entity.ImageEntity;
import com.company.MeTimesheet.service.ImageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "https://management-app-halliburton.vercel.app/", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        super();
        this.imageService = imageService;
    }


    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @GetMapping
    public List<ImageEntity> getAllImages() {
        return imageService.getAllImages();
    }


    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @GetMapping("/{id}")
    public ResponseEntity<ImageEntity> getImageById(@PathVariable Long id) {
        return imageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @PostMapping("/insert")
    public ResponseEntity<ImageEntity> uploadImage(
            @RequestParam("imageName") String imageName,
            @RequestParam("productQuantity") int productQuantity,
            @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageName(imageName);
        imageEntity.setProductQuantity(productQuantity);
        imageEntity.setImageData(imageFile.getBytes());

        ImageEntity savedImage = imageService.saveImage(imageEntity);
        return ResponseEntity.ok(savedImage);
    }

    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        if (imageService.getImageById(id).isPresent()) {
            imageService.deleteImage(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
