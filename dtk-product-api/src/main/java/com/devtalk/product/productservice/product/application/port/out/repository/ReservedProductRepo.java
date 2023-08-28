package com.devtalk.product.productservice.product.application.port.out.repository;

import com.devtalk.product.productservice.product.domain.product.Product;
import com.devtalk.product.productservice.product.domain.product.ProductReservedDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservedProductRepo extends JpaRepository<ProductReservedDetails, Long>, ReservedProductQueryableRepo {

    Product findAllById(Long consultationid);

    List<Product> findAllByConsultantId(Long consultant);
    List<ProductReservedDetails> findAllByMemberId(Long memberId);
}
