package io.reactivestax.controller;

import io.reactivestax.dto.ProductDto;
import io.reactivestax.entity.Product;
import io.reactivestax.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class productController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);

    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
