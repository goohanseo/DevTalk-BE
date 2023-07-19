package com.devtalk.product.productservice.product.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.sql.Time;

@Entity
@Table(name = "ResProduct")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
public class ResProduct {

    //예약상품일련번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regproduct_id", referencedColumnName = "regproduct_id")
    private RegProduct regProduct;

    //상담자 ID
    @Column(name = "counselor_id")
    private String counselorId;

    //예약상담 ID
    @Column(name = "counsertant_id")
    private String counsertantId;

    //상담시간
    @Column(name = "reservation_at")
    private Time reservationAt;

    //상태
    @Column(name = "status")
    private Enum status;

    //상담유형
    @Column(name = "type")
    private int type;

    //카테고리
    @Column(name = "category")
    private String category;

    //가격
    @Column(name = "price")
    private int price;


}
