package com.reactivestax.redis.controller;

import com.reactivestax.redis.entity.Product;
import com.reactivestax.redis.service.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductDto productDto;

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        System.out.println("Product here is: "+product);
       return productDto.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product){
        return productDto.updateProduct(id,product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id){
        return productDto.findProductById(id);
    }

    @GetMapping
    public List<Product> findAll(){
        return productDto.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id){
        return productDto.deleteProductById(id);
    }

}
