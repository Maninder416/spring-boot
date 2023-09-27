package io.reactivestax.dto;

import io.reactivestax.entity.Product;
import io.reactivestax.event.ProductEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private ProductEvent productEvent;
    private Product product;
}
