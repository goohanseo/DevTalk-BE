package com.devtalk.product.productservice.product.adapter.in.web;

import com.devtalk.product.productservice.product.application.port.in.RegProductUseCase;
import com.devtalk.product.productservice.product.domain.RegProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/regproduct")
@RequiredArgsConstructor

public class RegProductApiController {
    private final RegProductUseCase regProductUseCase;
    @GetMapping("/{counselorId}")
    public ResponseEntity<RegProduct> getInfoRegProduct(@PathVariable("counserlorId") String counselorId){
        RegProduct regProduct = regProductUseCase.getProductInfo(counselorId);
        return ResponseEntity.status(HttpStatus.OK).body(regProduct);//
    }
}
