package com.company.MeTimesheet.controller;

import com.company.MeTimesheet.entity.ImageEntity;
import com.company.MeTimesheet.entity.ImageResponse;
import com.company.MeTimesheet.service.ImageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        super();
        this.imageService = imageService;
    }


    private final String imageDirectory = "/Users/anaralizada/Desktop"; // Replace with the actual path

    @GetMapping("/with-links")
    public List<ImageResponse> getAllImagesWithLinks() {
        List<ImageEntity> images = imageService.getAllImages();
        return images.stream()
                .map(this::mapToImageResponse)
                .collect(Collectors.toList());
    }

    private ImageResponse mapToImageResponse(ImageEntity imageEntity) {
        ImageResponse response = new ImageResponse();
        response.setId(imageEntity.getImageId());
        response.setImageName(imageEntity.getImageName());
        response.setProductQuantity(imageEntity.getProductQuantity());
        response.setImageUrl("/api/images/" + imageEntity.getImageId() + "/image");
        return response;
    }

//    @GetMapping("/{id}/image")
//    public ResponseEntity<Resource> getImage(@PathVariable Long id) {
//        ImageEntity imageEntity = imageService.getImageById(id).orElse(null);
//
//        if (imageEntity != null) {
//            Path imagePath = Paths.get(imageDirectory, id + ".jpg");
//
//            try {
//                Resource resource = new UrlResource(imagePath.toUri());
//                return ResponseEntity.ok()
//                        .body(resource);
//            } catch (IOException e) {
//                e.printStackTrace(); // Handle exception appropriately
//                return ResponseEntity.notFound().build();
//            }
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping
    public List<ImageEntity> getAllImages() {
        return imageService.getAllImages();
    }

//    @GetMapping("/image-urls")
//    public List<String> getImageUrls() {
//        List<ImageEntity> images = imageService.getAllImages();
//        return images.stream()
//                .map(image -> "/api/images/" + image.getImageId() + "/image")
//                .collect(Collectors.toList());
//    }


    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping("/{id}")
    public ResponseEntity<ImageEntity> getImageById(@PathVariable Long id) {
        return imageService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:5173/")
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

    @CrossOrigin(origins = "http://localhost:5173/")
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
