package com.devtalk.product.productservice.product.application.port.out.repository;

import com.devtalk.product.productservice.product.domain.ResProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface ResProductRepository extends JpaRepository<ResProduct, Long> {
}
