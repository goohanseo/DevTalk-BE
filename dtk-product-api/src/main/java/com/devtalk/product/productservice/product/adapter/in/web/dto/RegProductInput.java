package com.devtalk.product.productservice.product.adapter.in.web.dto;


import com.devtalk.product.productservice.product.application.port.in.dto.RegistProdReq;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegProductInput {
    private Long counselorId;
    private Integer type;
    private Date reservationAt;
    private String category;
    private String status;

    public RegistProdReq toReq(Long counselorId){
        return RegistProdReq.builder()
                .counselorId(counselorId)
                .reservationAt(reservationAt)
                .type(type)
                .category(category)
                .status(status)
                .build();
    }

}
