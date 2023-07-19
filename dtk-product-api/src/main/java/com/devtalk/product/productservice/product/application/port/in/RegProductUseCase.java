package com.devtalk.product.productservice.product.application.port.in;

import com.devtalk.product.productservice.product.adapter.in.web.dto.RegProductOutput;
import com.devtalk.product.productservice.product.application.port.in.dto.RegistProdReq;
import com.devtalk.product.productservice.product.domain.RegProduct;

import java.sql.Date;

public interface RegProductUseCase {

    //등록상품 서비스 인터페이스의 등록상품정보 조회 메소드 선언
    RegProductOutput registRegProduct(RegistProdReq registProdReq);

}
