package com.devtalk.product.productservice.product.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "RegProduct")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
public class RegProduct implements Serializable {
    //등록 상품 일련번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;

    //전문가 ID
    @Column(name = "counselor_id")
    private String counselorId;

    //상담시간
    @Column(name = "reservation_at")
    private Time reservationAt;

    //상태
    @Column(name = "status")
    private String status;

    //카테고리별 상담 가능 여부
    //전화
    @Column(name = "voice")
    private boolean voice;
    //비디오
    @Column(name = "video")
    private boolean video;
    //대면
    @Column(name = "f2f")
    private boolean f2f;
}
