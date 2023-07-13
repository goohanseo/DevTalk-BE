package com.devtalk.product.productservice.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//상품변경됨 도메인 이벤트
public class ProductChanged {
    //등록상품일련번호
    private String regId;

    //전문가ID
    private String counselorId;

    //상담유형
    private String category;

    //상담시간
    private String reservationAt;

    //이벤트 유형
    private String eventType;
}
