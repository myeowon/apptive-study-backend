package com.yeowon.demo.repository;

import com.yeowon.demo.domain.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
