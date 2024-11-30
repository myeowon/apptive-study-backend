package com.yeowon.demo.dto.response;

import com.yeowon.demo.domain.Product;

public record ProductResponse(
        Long Id,
        String name,
        Integer price,
        Integer quantity
) {
    public static ProductResponse from(Product product){
        return new ProductResponse(product.getId(), product.getName(),product.getPrice(), product.getQuantity());
    }
}
