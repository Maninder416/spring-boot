package io.reactivestax.writeservice.dto;

import io.reactivestax.writeservice.entity.Product;
import io.reactivestax.writeservice.event.ProductEvent;
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
