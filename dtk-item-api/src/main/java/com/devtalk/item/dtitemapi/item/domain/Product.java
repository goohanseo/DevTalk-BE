package com.devtalk.item.dtitemapi.item.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    //키의 일련번호가 생성되는 규칙을 의미하는 Generatedvalue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    private int time;

    @Column(name = "tutor_id")
    private Long tutorId;

    //밑에는 다른 엔티티와의 매핑관계 설정
    //생명주기도 봐야됨

    //product 엔티티 생성
    //상품 생성 메서드 구현
    public static Product createProduct(Long tutorId){
        Product product = new Product();
        //product.settutorId(tutorId);
        //rental.settime();
        return product;
    }
    //상픔 수정 메서드 구현
    //상품 취소 메서드 구현
}
