//package com.devtalk.product.productservice.product.adapter.out.persistence;
//
//import com.devtalk.product.productservice.product.application.port.out.repository.RegProductQuearyableRepo;
//import com.devtalk.product.productservice.product.domain.RegProduct;
//import jakarta.persistence.EntityManager;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@Data
//@RequiredArgsConstructor //생성자 자동 주입 bean 생성 자동으로
////interface가 있으면 public시 헥사고날이 깨짐
//class RegProductQueryRepo implements RegProductQuearyableRepo {
//    //em으로 DB에 접근
//    private final EntityManager em;
//
//    @Override
//    public RegProduct findByCounselorId(String counselorId) {
//        return em.createQuery("select p from RegProduct p where p.counselorId = :counselorId", RegProduct.class)
//                .setParameter("coundselorId", counselorId).getSingleResult();
//    }
//}
