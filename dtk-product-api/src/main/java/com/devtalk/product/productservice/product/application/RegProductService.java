package com.devtalk.product.productservice.product.application;

import com.devtalk.product.productservice.product.adapter.in.web.dto.RegProductOutput;
import com.devtalk.product.productservice.product.application.port.in.RegProductUseCase;
import com.devtalk.product.productservice.product.application.port.in.dto.RegistProdReq;
import com.devtalk.product.productservice.product.application.port.in.dto.RegistProdRes;
import com.devtalk.product.productservice.product.application.port.out.repository.RegProductRepo;
import com.devtalk.product.productservice.product.application.validator.Validator;
import com.devtalk.product.productservice.product.domain.RegProduct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegProductService implements RegProductUseCase {
    private final RegProductRepo regProductRepo;
    private final Validator validator;
    private final RegProduct regProduct;
    private final RegProductOutput regProductOutput;
    @Transactional
    public RegProductOutput registRegProduct(RegistProdReq registProdReq) {
        validator.validate(registProdReq);

        ModelMapper mapper = new ModelMapper();
        RegProduct regProduct = mapper.map(registProdReq, RegProduct.class);

        regProductRepo.save(regProduct);
        RegProductOutput regProductOutput = mapper.map(regProduct, RegProductOutput.class);
        return regProductOutput;
    }

    //상품 서비스 구현체의 등록 상품 정보 조회 메서드 구현
    //조회 기능은 매칭 서비스의 매칭 기능과 관련 매칭 서비스의 동기 호출에 응답

}
