package com.devtalk.product.productservice.product.adapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consultation", configuration = {FeignConfiguration.class})
public interface ConsultationClient {
    @GetMapping("/api/consultants/consultations/{consultationId}")
    ResponseEntity<ConsultatntInfoDTO> findConsultantInfo(@PathVariable("consultantId") long consultantId);
}
