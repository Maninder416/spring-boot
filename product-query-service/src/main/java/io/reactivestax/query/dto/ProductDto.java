package io.reactivestax.query.dto;

import io.reactivestax.query.entity.Product;
import io.reactivestax.query.event.ProductEvent;
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
