package kz.storelink.product.controller;

import kz.storelink.product.model.Product;
import kz.storelink.product.repository.ProductRepository;
import kz.storelink.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @GetMapping("/product/find/{name}")
    public ResponseEntity<List<Product>> getProduct(@PathVariable String name) {
        return new ResponseEntity<>(productService.searchProduct(name), HttpStatus.OK);
    }

    @GetMapping("/product/list")
    public ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

}
