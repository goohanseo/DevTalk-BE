package com.devtalk.product.productservice.product.application.port.in;

import com.devtalk.product.productservice.product.adapter.in.web.dto.RegProductDTO;
import com.devtalk.product.productservice.product.domain.RegProduct;

public interface RegProductUseCase {

    //등록상품 서비스 인터페이스의 등록상품정보 조회 메소드 선언
    RegProduct getProductInfo(String counselorId);

}
