package com.reactivestax.redis.service;

import com.reactivestax.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDto {

    @Autowired
    private RedisTemplate redisTemplate;

    public Product save(Product product){
        redisTemplate.opsForHash().put("Product",product.getId(),product);
        return product;
    }


    @CachePut(value = "Product", key = "#id")
    public Product updateProduct(int id, Product updatedProduct){
        redisTemplate.opsForHash().put("Product",id,updatedProduct);
        return updatedProduct;
    }

    public List<Product> findAll(){
        return redisTemplate.opsForHash().values("Product");
    }

    @Cacheable(value = "Product", key = "#id", unless = "#result.price>200")
    public Product findProductById(int id){
        System.out.println("Calling this method again");
        return (Product) redisTemplate.opsForHash().get("Product",id);
    }

    @CacheEvict(value = "Product",key = "#id")
    public String deleteProductById(int id){
        redisTemplate.opsForHash().delete("Product",id);
            return "Product id: "+id+ " removed";
        }





}
