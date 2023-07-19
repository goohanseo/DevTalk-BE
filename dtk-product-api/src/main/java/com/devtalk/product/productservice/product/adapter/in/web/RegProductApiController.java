package com.devtalk.product.productservice.product.adapter.in.web;

import com.devtalk.product.productservice.product.adapter.in.web.dto.RegProductInput;
import com.devtalk.product.productservice.product.application.RegProductService;
import com.devtalk.product.productservice.product.application.port.in.RegProductUseCase;
import com.devtalk.product.productservice.product.application.port.in.dto.RegistProdReq;
import com.devtalk.product.productservice.product.application.port.in.dto.RegistProdRes;
import com.devtalk.product.productservice.product.domain.RegProduct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class RegProductApiController {
    Environment env;
    private final RegProductUseCase regProductUseCase;
    @Autowired
    public RegProductApiController(Environment env, RegProductUseCase regProductUseCase){
        this.env = env;
        this.regProductUseCase = regProductUseCase;
    }


    @PostMapping("/v1/regproduct/")
    public ResponseEntity<RegistProdRes> registregProduct(@RequestBody @Validated RegProductInput regProductInput)
    {
        //RegProductInput -> RegistProdReq
//        ModelMapper mapper = new ModelMapper();
//        RegistProdReq registProdReq = mapper.map(regProductInput, RegistProdReq.class);

        regProductUseCase.registRegProduct(regProductInput.toReq());

        return ResponseEntity.ok().build();
    }
}
