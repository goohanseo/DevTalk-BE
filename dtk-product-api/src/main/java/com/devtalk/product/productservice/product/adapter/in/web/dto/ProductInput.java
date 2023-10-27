package com.devtalk.product.productservice.product.adapter.in.web.dto;

import com.devtalk.product.productservice.product.application.port.in.dto.ProductReq;
import com.devtalk.product.productservice.product.domain.product.Product;
import com.devtalk.product.productservice.product.domain.product.ProductProceedType;
//import com.devtalk.product.productservice.product.domain.product.ReservedProceedType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProductInput {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class RegistrationInput{

        private Long consultantId;
        private String reservationDate;
        private String reservationTime;
        private ProductProceedType productProceedType;

        public ProductReq.RegistProdReq toReq( ){
            LocalDate date = LocalDate.parse(reservationDate);
            LocalTime time = LocalTime.parse(reservationTime);
            LocalDateTime reservationAt = LocalDateTime.of(date, time);

            return ProductReq.RegistProdReq.builder()
                    .memberId(consultantId)
                    .reservationAt(reservationAt)
                    .productProceedType(productProceedType)
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SearchInput{

        private Long consultantId;
        private String reservationDate;
        private String reservationTime;

        public ProductReq.SearchProdReq toReq( ){
            LocalDate date = LocalDate.parse(reservationDate);
            LocalTime time = LocalTime.parse(reservationTime);
            LocalDateTime reservationAt = LocalDateTime.of(date, time);

            return ProductReq.SearchProdReq.builder()
                    .memberId(consultantId)
                    .reservationAt(reservationAt)
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class UpdateInput{

        private String reservationDate;
        private String reservationTime;
        private ProductProceedType type;

        public ProductReq.UpdateProdReq toReq(){
            LocalDate date = LocalDate.parse(reservationDate);
            LocalTime time = LocalTime.parse(reservationTime);
            LocalDateTime reservationAt = LocalDateTime.of(date, time);

            return ProductReq.UpdateProdReq.builder()
                    .reservationAt(reservationAt)
                    .productProceedType(type)
                    .build();
        }
    }
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class DeleteInput{

        private String reservationDate;
        private String reservationTime;

        public ProductReq.DeleteProdReq toReq(){
            LocalDate date = LocalDate.parse(reservationDate);
            LocalTime time = LocalTime.parse(reservationTime);
            LocalDateTime reservationAt = LocalDateTime.of(date, time);

            return ProductReq.DeleteProdReq.builder()
                    .reservationAt(reservationAt)
                    .build();
        }
    }



}





