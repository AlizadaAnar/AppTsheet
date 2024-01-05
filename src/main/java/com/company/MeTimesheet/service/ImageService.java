package com.company.MeTimesheet.service;

import com.company.MeTimesheet.entity.ImageEntity;
import com.company.MeTimesheet.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }

    public Optional<ImageEntity> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public ImageEntity saveImage(ImageEntity imageEntity) {
        return imageRepository.save(imageEntity);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
