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

    //전문가 ID
    @Column(name = "counselor_id")
    private String counselorId;

    //상담시간
    @Column(name = "reservation_at")
    private Time reservationAt;

    //@Enumerated(EnumType.STRING)
    //상담유형
    @Column(name = "category")
    private Enum category;

    //상태
    //@Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Enum status;

    //예약상담 ID
    @Column(name = "counsertant_id")
    private String counsertantId;

}
