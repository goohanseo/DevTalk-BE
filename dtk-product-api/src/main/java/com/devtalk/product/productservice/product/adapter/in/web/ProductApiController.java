package com.devtalk.product.productservice.product.adapter.in.web;


import com.devtalk.product.productservice.product.adapter.in.web.dto.ProductInput;
import com.devtalk.product.productservice.product.adapter.in.web.dto.ProductOutput;
import com.devtalk.product.productservice.product.application.port.in.ProductUseCase;
import com.devtalk.product.productservice.product.application.port.in.dto.ProductReq.ReserveProdReq;

import com.devtalk.product.productservice.product.application.port.in.dto.ProductRes;
import com.devtalk.product.productservice.product.domain.product.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@EnableDiscoveryClient
@RestController
@Slf4j
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor

public class ProductApiController {
    private final ProductUseCase productUseCase;

    //상품등록API - 완료
    @PostMapping("/consultant/{consultantid}/register")
    public ResponseEntity<?> registProduct(@RequestBody @Validated ProductInput.RegistrationInput registrationInput,
                                           @PathVariable Long consultantId)
    {
        productUseCase.registProduct(registrationInput.toReq(consultantId));
        return ResponseEntity.ok().build();
    }

    //상담사 예약 가능 상품 조회API - 완료
    //내담자가 상담을 원하는 상담자의 예약 가능 시간을 확인한다.
    @GetMapping("/search/consultant/{consultantid}")
    public ResponseEntity<ProductOutput> searchList(@PathVariable Long consultantId)
    {
         = productUseCase.searchList(consultantId);
        return ResponseEntity.ok().build();
    }

    //예약상품리스트조회API - 진행 중
    @GetMapping("search/memberId/{memberId}")
    public ResponseEntity<?> reservationList(@PathVariable Long memberId)
    {
        productUseCase.searchReservedProductsByMember(memberId);
        return ResponseEntity.ok().build();
    }
    //상품예약API - 완료
    @PostMapping("/productId/{productId}/")
    public ResponseEntity<?> reserveProduct(@RequestBody @Validated ProductInput.ReservationInput reservationInput,
                                            @PathVariable Long productId)
    {
        productUseCase.reserveProduct(reservationInput.toReq(productId));
        return ResponseEntity.ok().build();
    }

    //예약상품조회API - 완료
    @GetMapping("search?consultation={consultationId}")
    public ResponseEntity<?> searchProduct(@PathVariable Long consultationId)
    {
        productUseCase.searchReservedDetatils(consultationId);
        return ResponseEntity.ok().build();
    }

    //상품삭제API - 완료
    @DeleteMapping("delete/consultation/{consultationId}")
    public ResponseEntity<?> deleteProduct(@RequestParam Long consultationId)
    {
        productUseCase.deleteReservation(consultationId);
        return ResponseEntity.ok().build();
    }
}
