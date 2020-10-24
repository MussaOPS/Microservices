package kz.storelink.storage.service;

import kz.storelink.storage.model.Product;
import kz.storelink.storage.model.Storage;
import kz.storelink.storage.model.User;
import kz.storelink.storage.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository storageRepository;
    private final RestTemplate restTemplate;

    public Storage getStorageByUserId(Long id){
        User user = restTemplate.getForObject("http://order-service/user/" + id, User.class);
        Optional<Storage> optionalStorage = storageRepository.getByUser(user);

        return optionalStorage.get();
    }

    public Storage createStorage(Long userId){
        User user = restTemplate.getForObject("http://order-service/user/" + userId, User.class);
        Storage storage = new Storage();
        storage.setUser(user);

        return storageRepository.save(storage);
    }

    public Storage addProductToStorage(Long userId, Long productId){
        User user = restTemplate.getForObject("http://order-service/user/" + userId, User.class);
        Optional<Storage> optionalStorage = storageRepository.getByUser(user);

        Storage storage = optionalStorage.get();
        Product product = restTemplate.getForObject("http://product-service/product/" + productId, Product.class);
        storage.getProduct().add(product);

        return storageRepository.save(storage);
    }

    public Storage deleteProductFromStorage(Long userId, Long productId){
        User user = restTemplate.getForObject("http://order-service/user/" + userId, User.class);
        Optional<Storage> optionalStorage = storageRepository.getByUser(user);
        Storage storage = optionalStorage.get();
        Product product = restTemplate.getForObject("http://product-service/product/" + productId, Product.class);

        storage.getProduct().remove(product);

        return storageRepository.save(storage);
    }

    public List<Storage> findAll() {
        return storageRepository.findAll();
    }
}
