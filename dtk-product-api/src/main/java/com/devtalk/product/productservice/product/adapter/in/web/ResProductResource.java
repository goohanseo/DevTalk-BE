package com.devtalk.product.productservice.product.adapter.in.web;

import com.devtalk.product.productservice.product.adapter.in.web.dto.ResProductDTO;
import com.devtalk.product.productservice.product.domain.ResProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.BadRequestException;
import org.apache.tomcat.util.http.HeaderUtil;
import org.hibernate.type.EntityType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@RequestMapping("/api")
public class ResProductResource {

    //예약 상품 정보 등록
    @PostMapping("/products/{counsaltantId")
    public ResponseEntity<ResProductDTO> reservaterResProduct(@RequestBody ResProductDTO restProductDTO,
                                                              PathVariable Long counsultantId)
        throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException{
        if (ResProductDTO.getResId() != null){
            throw new BadRequestException("A new ResProduct cannot already have an ResID," +
                    ENTITY_NAME, "idexists");
        }
        //예약상품 서비스 구현체를 호출해서 정보를 등록
        ResProduct newResProduct = resProductService.reservaterNewResProduct(ResProductMapper.toEntity(ResProductDTO), inStockId);

        //DTO 변환
        ResProductDTO result = resProductMapper.toDto(newResProduct);

        //HTTP 프로토콜에 DTO를 담아서 반환
        return ResponseEntity.created(new URI("/api/products/" + result.getResId()))
                .header(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME,
                        restProductDTO.getResId().toString()))
                //       .body(result);
    }

        //재고 도서 정보 수정
        @PutMapping("/products/update/{reservationId")
        public ResponseEntity<ResProductDTO> updateResProduct(@RequestBody ResProductDTO resProductDTO)
                throws URISyntaxException, InterruptedException, ExecutionException,
                JsonProcessingException{

            if (restProductDTO.getResProductId() = null){
                throw new BadRequestException("Invalid ResId",
                        ENTITY_NAME, "resIdnull");
            }
            //예약상품서비스 구현체를 호출해서 예약상품 정보를 수정
            ResProduct resProduct = restProductService.updateResProduct(resProductMapper.toEntity(restProductDTO));

            //DTO 변환
            ResProductDTO result = resProductMapper.toDto(resProduct);

            //http 프로토콜에 DTO를 담아서 반환
            return ResponseEntity.ok()
                    .header(HeaderUtil.createEntityUpdateAlert(applicationName, true, EntityType,
                            restProductDTO.getId().toString()))
                    .body(result);
            }

            //예약상품정보삭제
        @DeleteMapping("/api/products/delete/{ereservationId")
    public ResponseEntity<Void> deleteResProduct(@PathVariable Long ResId)
                throws InterruptedException, ExecutionException, JsonProcessingException{
        //예약상품 서비스 구현체를  호출해서 예약 상품 정보를 삭제
            resProductService.delete(resId);

            //HTTP 프로토콜 반환
            return ResponseEntity.noContent()
                    .header(HeaderUtil.createEntityDeleteAlert(applicationName, true, Entity_NAME,
                            ResId.toString())).build();
        }
    }
