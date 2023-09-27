package io.reactivestax.controller;


import io.reactivestax.entity.Product;
import io.reactivestax.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }


}
