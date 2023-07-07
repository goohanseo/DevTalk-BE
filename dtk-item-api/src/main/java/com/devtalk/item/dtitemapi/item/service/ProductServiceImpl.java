package com.devtalk.item.dtitemapi.item.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl {
    //상품 예약 처리 구현
   // Product reserveProduct(Long time, Long tutorid){
       // Product product = ProductRepository
        //.findByUserId()
            //}
    //외부 마이크서비스로 이벤트를 전송할 때는 의존성을 낮추기 위해 비동기 호출
    //비동기 이벤트 처리를 위해 아웃바운드 어댑터 호출
    //아웃바운드 어댑터 클래스를 직접 호출x 아웃바운드 어댑터의 행위가 추상화된 인터페이스 클래스에 의존
    //메시지를 ㄴ프카에 직접 전송하는 것이 구현된 부분은 아웃바운드 어댑터 영역에서
}
