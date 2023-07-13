package com.devtalk.product.productservice.product.repository;

import com.devtalk.product.productservice.product.domain.RegProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface RegProductRepository {
    Page<RegProduct> findByCounselorId(String counselorId, Pageable pageable);
}
