package com.devtalk.product.productservice.unittest;

import com.devtalk.product.productservice.product.application.RegProductService;
import com.devtalk.product.productservice.product.application.port.in.dto.RegistProdReq;
import com.devtalk.product.productservice.product.application.port.out.repository.RegProductRepo;
import com.devtalk.product.productservice.product.application.validator.Validator;
import com.devtalk.product.productservice.product.domain.RegProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;


import java.util.Date;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static reactor.retry.Repeat.times;

@ExtendWith(MockitoExtension.class)
class RegistServiceUnitTest {
    @InjectMocks
    RegProductService regProductService;

    @Mock
    Validator validator;
    @Mock
    RegProductRepo regProductRepo;

    /*
    테스트 케이스
    *S. 예약가능상품 등록 성공
    *F. 예약가능상품 등록 실패
     */


    @Test
    @DisplayName("S. 등록 성공")
    void RegistSuccess(){
        //given
        //RegProduct regProduct = Mockito.mock(RegProduct.class);
        Long counselorId = 1L;
        Date reservationAt = new Date();
        Integer type = 1;
        String category = "진로상담";
        String status = "예약 가능";
        RegistProdReq registProdReq = registProdReq(counselorId, reservationAt, type, category, status);

        willDoNothing().given(validator).validate(registProdReq);
        given(regProductRepo.save(Mockito.any(RegProduct.class))).willReturn(null);

        //when
        regProductService.registRegProduct(registProdReq);
        //then
        BDDMockito.then(regProductRepo).should(Mockito.times(1)).save(ArgumentMatchers.any());
    }

    private RegistProdReq registProdReq(Long counselorId, Date reservationAt, Integer type, String category, String status) {
        return RegistProdReq.builder()
                .counselorId(counselorId)
                .reservationAt(reservationAt)
                .type(type)
                .category(category)
                .status(status)
                .build();
    }

}
