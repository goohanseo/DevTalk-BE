package com.devtalk.product.productservice.product.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Builder
@Getter
@Table(name = "Reg_Product")
@AllArgsConstructor
@NoArgsConstructor
public class RegProduct{
    //등록 상품 일련번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;

    //전문가 ID
    @OneToOne(mappedBy = "regProduct")
    private ResProduct resProduct;

    @Column(name = "coundselor_id")
    private Long counselorId;

    //상담시간
    @Column(name = "reservation_at")
    private java.util.Date reservationAt;

    //상담유형
    @Column(name = "type")
    private int type;

    //카테고리
    @Column(name = "category")
    private String category;

    //상태
    @Column(name = "status")
    private String status;

    public static RegProduct registRegProduct(Long counselorId, Date reservationAt , int type, String category, String status){
        return RegProduct.builder()
                .counselorId(counselorId)
                .reservationAt(reservationAt)
                .type(type)
                .category(category)
                .status(status)
                .build();
    }

}
