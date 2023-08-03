package io.reactivestax.dto;

import io.reactivestax.event.OrderStatus;

public class OrderResponseDto {
    private Integer userId;
    private Integer productId;
    private Integer amount;
    private Integer orderId;
    private OrderStatus orderStatus;

}
