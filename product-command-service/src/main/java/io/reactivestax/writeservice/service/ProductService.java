package io.reactivestax.writeservice.service;

import io.reactivestax.writeservice.entity.Product;
import io.reactivestax.writeservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Product does not found for id: " + id);
        }
        Product product1 = byId.get();
        product1.setDescription(product.getDescription());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productRepository.save(product1);
    }

    public void deleteProduct(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Product does not found for id: " + id);
        }
        productRepository.deleteById(id);
    }
}
