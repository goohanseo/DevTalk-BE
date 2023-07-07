package com.devtalk.item.dtitemapi.item.repository;

import com.devtalk.item.dtitemapi.item.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
