package io.reactivestax.service;

import io.reactivestax.dto.ProductDto;
import io.reactivestax.entity.Product;
import io.reactivestax.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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

    @KafkaListener(topics = "product-data-topic", groupId = "product-event")
    public void processProductEvent(ProductDto productDto){
        Product product = productDto.getProduct();
        System.out.println("=================================");
        System.out.println("payload: "+productDto);
        System.out.println("=================================");
        switch (productDto.getProductEvent()){
            case PRODUCT_CREATED:
                productRepository.save(product);
                break;
            case PRODUCT_UPDATED:
                Optional<Product> byId = productRepository.findById(product.getId());
                if(byId.isPresent()){
                    byId.get().setDescription(product.getDescription());
                    byId.get().setName(product.getName());
                    byId.get().setPrice(product.getPrice());
                }
                productRepository.save(byId.get());
                break;
            case PRODUCT_DELETED:
                productRepository.delete(product);
                break;
            default:
                throw new RuntimeException("invalid type");

        }

    }
}
