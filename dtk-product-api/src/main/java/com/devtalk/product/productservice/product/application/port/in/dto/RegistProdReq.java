package com.devtalk.product.productservice.product.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegistProdReq {

            private Long counselorId;
            private Date reservationAt;
            private Integer type;
            private String category;
            private String status;
}
