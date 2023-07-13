package com.devtalk.product.productservice.product.application;

import com.devtalk.product.productservice.product.application.port.in.RegProductUseCase;
import com.devtalk.product.productservice.product.application.port.out.repository.RegProductQuearyableRepo;
import com.devtalk.product.productservice.product.domain.RegProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class RegProductService implements RegProductUseCase {
    private final RegProductQuearyableRepo regProductQuearyableRepo;
    @Override
    public RegProduct getProductInfo(String counselorId) {
        RegProduct regProduct = regProductQuearyableRepo.findByCounselorId(counselorId);
        return regProduct;
    }

    //상품 서비스 구현체의 등록 상품 정보 조회 메서드 구현
    //조회 기능은 매칭 서비스의 매칭 기능과 관련 매칭 서비스의 동기 호출에 응답

}
