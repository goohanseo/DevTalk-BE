package com.devtalk.product.productservice.product.application.port.in.dto;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistProdReq {

            private Long counselorId;
            private Date reservationAt;
            private Integer type;
            private String category;
            private String status;
}
