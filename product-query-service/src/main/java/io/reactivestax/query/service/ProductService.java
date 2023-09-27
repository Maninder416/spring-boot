package io.reactivestax.query.service;

import io.reactivestax.query.entity.Product;
import io.reactivestax.query.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product findProductById(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Product does not found for id: " + id);
        }
        return byId.get();
    }
}
