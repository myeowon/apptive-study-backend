package com.yeowon.demo.service;

import com.yeowon.demo.domain.Product;
import com.yeowon.demo.dto.request.ProductRequest;
import com.yeowon.demo.exception.Product.ProductNameDuplicateException;
import com.yeowon.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Product join(ProductRequest productRequest) {
        Product product = new Product(productRequest.name(), productRequest.price(),productRequest.quantity());
        validateDuplicateProduct(product);
        return productRepository.save(product);
    }

    private void validateDuplicateProduct(Product product) {
        productRepository.findByName(product.getName())
                .ifPresent(p -> {
                    throw new ProductNameDuplicateException();
                });
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findOne(Long productId) {
        return productRepository.findById(productId);
    }

}
