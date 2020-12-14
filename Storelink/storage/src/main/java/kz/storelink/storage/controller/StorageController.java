package kz.storelink.storage.controller;

import kz.storelink.storage.model.Storage;
import kz.storelink.storage.repository.StorageRepository;
import kz.storelink.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class StorageController {

    private final StorageService storageService;
    private final StorageRepository storageRepository;

    public StorageController(StorageService storageService, StorageRepository storageRepository) {
        this.storageService = storageService;
        this.storageRepository = storageRepository;
    }

    @GetMapping("/storage/{userId}")
    public ResponseEntity<Storage> getWishlist(@PathVariable Long userId) {
        return new ResponseEntity<>(storageService.getStorageByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/storage/list")
    public ResponseEntity<List<Storage>> getMovie() {
        return new ResponseEntity<>(storageService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/storage/add/{userId}/{productId}")
    public ResponseEntity<Storage> createMovie(@PathVariable Long userId, @PathVariable Long productId) {
        return new ResponseEntity<>(storageService.addProductToStorage(userId, productId), HttpStatus.CREATED);
    }

    @PutMapping("/storage/delete/{userId}/{productId}")
    public ResponseEntity<Storage> deleteMovie(@PathVariable Long userId, @PathVariable Long productId) {
        return new ResponseEntity<>(storageService.deleteProductFromStorage(userId, productId), HttpStatus.CREATED);
    }

    @PostMapping("/storage/{userId}")
    public ResponseEntity<Storage> createMovie(@PathVariable Long userId) {
        return new ResponseEntity<>(storageService.createStorage(userId), HttpStatus.CREATED);
    }

}
