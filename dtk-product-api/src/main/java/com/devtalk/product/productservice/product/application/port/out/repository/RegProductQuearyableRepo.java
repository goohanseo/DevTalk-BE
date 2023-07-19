package com.devtalk.product.productservice.product.application.port.out.repository;

import com.devtalk.product.productservice.product.domain.RegProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@SuppressWarnings("unused")
public interface RegProductQuearyableRepo {
    Optional<RegProduct> findByCounselorId(Long counselorId);
}
