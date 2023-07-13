package com.devtalk.product.productservice.product.application.service;

import com.devtalk.product.productservice.product.domain.ResProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class ResProductServiceImpl implements ResProductService{
    @Override
    public ResProduct reserveNewProduct(ResProduct resProduct, Long regProductId)
            throws InterruptedException, ExecutionException, JsonProcessingException {
        //예약상품저장
        ResProduct newResProduct = resProductRepository.save(resProduct);
        //등록상품변경
        regProductService.update(regProductId);
        //내부 메서드 호출
        //sendRegProductEvent("NEW_PRODUCT", newResProduct.getResId());
        return newResProduct;
    }

    @Override
    public ResProduct updateProduct(ResProduct resProduct)
            throws InterruptedException, ExecutionException, JsonProcessingException {
        //예약상품수정
        ResProduct updatedResProduct = resProductRepository.save(resProduct);
        //내부 메서드 호출
        //sendRegProductEvent("UPDATE_PRODUCT", resProduct.getResId());
        return updatedResProduct;
    }

    @Override
    public void delete(Long resId)
            throws InterruptedException, ExecutionException, JsonProcessingException {
        log.debug("Requeset to delete ResProduct", resId);
        //내부 메서드 호출
        //sendRegProductEvent("DELETE_PRODUCT", resId);
        resProductRepository.deleteById(resId);

    }

    @Override
    public ResProduct
}