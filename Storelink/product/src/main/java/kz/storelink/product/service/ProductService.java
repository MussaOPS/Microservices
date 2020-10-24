package kz.storelink.product.service;

import kz.storelink.product.model.Product;
import kz.storelink.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("No product, ID not found");
        }
        return productRepository.findById(id).get();
    }

    public List<Product> searchProduct(String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
