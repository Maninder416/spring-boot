package io.reactivestax.query.controller;


import io.reactivestax.query.entity.Product;
import io.reactivestax.query.service.ProductService;
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
