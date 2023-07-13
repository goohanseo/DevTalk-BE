package com.devtalk.product.productservice.product.application.service;

import com.devtalk.product.productservice.product.domain.ResProduct;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutionException;

public interface ResProductService {
    //예약 상품 등록
    //매개변수가 등록상품객체와 예약상품일련번호인 이유:
    ResProduct reserveNewProduct(ResProduct resProduct, Long regProductId)
        throws InterruptedException, ExecutionException, JsonProcessingException;

    //예약 상품 수정
    ResProduct updateProduct(ResProduct resProduct)
            throws InterruptedException, ExecutionException, JsonProcessingException;

    //예약 상품 삭제
    //삭제 및 다시 등록상품으로 원위치
    void delete(Long resId)
            throws InterruptedException, ExecutionException, JsonProcessingException;
}
