package com.yeowon.demo.controller;

import com.yeowon.demo.domain.Product;
import com.yeowon.demo.dto.ApiResponse;
import com.yeowon.demo.dto.request.ProductRequest;
import com.yeowon.demo.dto.response.ProductResponse;
import com.yeowon.demo.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products/new")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody @Valid ProductRequest productRequest) {
        Product product = productService.join(productRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.successResponse(ProductResponse.from(product)));
    }

    @GetMapping( "/products")
    public ResponseEntity<ApiResponse<?>> list() {
        List<Product> products = productService.findProducts();

        List<ProductResponse> productResponses = products.stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.successResponse(productResponses));
    }
}