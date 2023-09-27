package io.reactivestax.service;

import io.reactivestax.dto.ProductDto;
import io.reactivestax.event.ProductEvent;
import io.reactivestax.repository.ProductRepository;
import io.reactivestax.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.topic.name}")
    private String topicName;

    public Product createProduct(ProductDto product) {
        Product saveProduct = productRepository.save(product.getProduct());
        ProductDto productDto = new ProductDto(ProductEvent.PRODUCT_CREATED,saveProduct);
        kafkaTemplate.send(topicName,productDto);
        return productRepository.save(saveProduct);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Product does not found for id: " + id);
        }
        Product product1 = byId.get();
        product1.setDescription(productDto.getProduct().getDescription());
        product1.setName(productDto.getProduct().getName());
        product1.setPrice(productDto.getProduct().getPrice());
        ProductDto productDto1 = new ProductDto(ProductEvent.PRODUCT_UPDATED,product1);
        kafkaTemplate.send(topicName,productDto1);
        return productRepository.save(product1);
    }

    public void deleteProduct(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Product does not found for id: " + id);
        }
        ProductDto productDto = new ProductDto(ProductEvent.PRODUCT_DELETED,byId.get());
        kafkaTemplate.send(topicName,productDto);
        productRepository.deleteById(id);
    }
}
