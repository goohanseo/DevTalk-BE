package com.devtalk.product.productservice.product.application.port.in.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegistProdRes {
    private Long counselorId;
    private Date reservationAt;
    private Integer type;
    private String category;
    private String status;
}
