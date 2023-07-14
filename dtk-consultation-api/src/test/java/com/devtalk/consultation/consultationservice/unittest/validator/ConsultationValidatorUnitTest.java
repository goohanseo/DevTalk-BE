package com.devtalk.consultation.consultationservice.unittest.validator;

import com.devtalk.consultation.consultationservice.consultation.application.port.in.dto.ConsultationReq;
import com.devtalk.consultation.consultationservice.consultation.application.port.out.client.ProductServiceClient;
import com.devtalk.consultation.consultationservice.consultation.application.port.out.client.dto.ProductRes;
import com.devtalk.consultation.consultationservice.consultation.application.port.out.repository.LinkItemQueryableRepository;
import com.devtalk.consultation.consultationservice.consultation.application.validator.ConsultationValidator;
import com.devtalk.consultation.consultationservice.consultation.application.validator.FileValidator;
import com.devtalk.consultation.consultationservice.consultation.domain.consultation.Consultation;
import com.devtalk.consultation.consultationservice.consultation.domain.consultation.ProcessMean;
import com.devtalk.consultation.consultationservice.consultation.domain.member.Consultant;
import com.devtalk.consultation.consultationservice.consultation.domain.member.Consulter;
import com.devtalk.consultation.consultationservice.consultation.domain.member.RoleType;
import com.devtalk.consultation.consultationservice.global.error.execption.FileException;
import com.devtalk.consultation.consultationservice.global.vo.BaseFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.devtalk.consultation.consultationservice.consultation.application.port.in.dto.ConsultationReq.*;
import static com.devtalk.consultation.consultationservice.consultation.application.port.out.client.dto.ProductRes.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultationValidatorUnitTest {
    final Integer fileListMaxSize = 10485760;
    final Integer fileListMaxCount = 3;

    @InjectMocks ConsultationValidator consultationValidator;
    @Mock ProductServiceClient productServiceClient;
    @Mock LinkItemQueryableRepository linkItemQueryableRepository;

    @Spy FileValidator fileValidator = new FileValidator(fileListMaxSize, fileListMaxCount);

    /** 테스트 케이스
     * S. 상담 예약 성공
     * F. 상담 예약 실패
         * F1. 상담 예약 실패 - 첨부파일의 최대 허용 개수 초과
         * F2. 상담 예약 실패 - 첨부파일 리스트의 총 용량이 최대 허용 용량 초과
         * F3. 상담 예약 실패 - 금지된 확장자를 가진 파일이 첨부파일에 포함됨
         * F4. 상담 예약 실패 - 요청으로 들어온 상품 정보와 실제 상품 정보가 불일치
     */

    @Test
    @DisplayName("F1. 상담 예약 실패 - 첨부파일의 최대 허용 개수 초과")
    void 상담예약실패_첨부파일최대허용개수초과() {
        // given
        Consulter consulter = getConsulter();
        Consultation consultation = getConsultation(consulter);
        Consultant consultant = getConsultant();
        Long productId = 3L;

        List<MultipartFile> attachedFileList = new ArrayList<>();
        for (int i = 0; i < fileListMaxCount-2; i++) {
            attachedFileList.add(new MockMultipartFile("file1", "file1.pdf", "pdf", "example".getBytes(StandardCharsets.UTF_8)));
        }

        ReservationReq reservationReq = getReservationReq(consulter.getId(), consultant.getId(), productId, attachedFileList);


        // when, then
        assertThrows(FileException.class, () -> consultationValidator.validate(reservationReq));
    }

    @Test
    @DisplayName("F2. 상담 예약 실패 - 첨부파일 리스트의 총 용량이 최대 허용 용량 초과")
    void 상담예약실패_첨부파일최대허용용량초과() {
        // given
        Consulter consulter = getConsulter();
        Consultation consultation = getConsultation(consulter);
        Consultant consultant = getConsultant();
        Long productId = 3L;

        List<MultipartFile> attachedFileList = new ArrayList<>();
        for (int i = 0; i < fileListMaxCount-2; i++) {
            attachedFileList.add(new MockMultipartFile("file1", "file1.pdf", "pdf", new byte[fileListMaxSize+1]));
        }

        ReservationReq reservationReq = getReservationReq(consulter.getId(), consultant.getId(), productId, attachedFileList);


        // when, then
        assertThrows(FileException.class, () -> consultationValidator.validate(reservationReq));
    }

    @Test
    @DisplayName("F3. 상담 예약 실패 - 금지된 확장자를 가진 파일이 첨부파일에 포함됨")
    void 상담예약실패_금지된확장자포함() {
        // given
        Consulter consulter = getConsulter();
        Consultation consultation = getConsultation(consulter);
        Consultant consultant = getConsultant();
        Long productId = 3L;

        List<MultipartFile> attachedFileList = new ArrayList<>();
        for (int i = 0; i < fileListMaxCount-2; i++) {
            attachedFileList.add(new MockMultipartFile("file1", "file1.sql", "sql", new byte[fileListMaxSize+1]));
        }

        ReservationReq reservationReq = getReservationReq(consulter.getId(), consultant.getId(), productId, attachedFileList);


        // when, then
        assertThrows(FileException.class, () -> consultationValidator.validate(reservationReq));
    }

    @Test
    @DisplayName("F4. 상담 예약 실패 - 요청으로 들어온 상품 정보와 실제 상품 정보가 불일치")
    void 상담예약실패_상품정보불일치() {
        // given
        Consulter consulter = getConsulter();
        Consultation consultation = getConsultation(consulter);
        Consultant consultant = getConsultant();
        Long productId = 3L;

        List<MultipartFile> attachedFileList = new ArrayList<>();
        for (int i = 0; i < fileListMaxCount-2; i++) {
            attachedFileList.add(new MockMultipartFile("file1", "file1.sql", "sql", new byte[fileListMaxSize+1]));
        }

        ReservationReq reservationReq = getReservationReq(consulter.getId(), consultant.getId(), productId, attachedFileList);
        given(productServiceClient.getProduct(productId)).willReturn(ProductSearchRes.builder().consultantId(consultant.getId()).reservationAT(LocalDateTime.now().plusDays(1)).cost(30000).build());

        // when, then
        assertThrows(FileException.class, () -> consultationValidator.validate(reservationReq));
    }

    private ReservationReq getReservationReq(Long consulterId, Long consultantId, Long productId, List<MultipartFile> attachedFileList) {
        return ReservationReq.builder()
                .consulterId(consulterId)
                .consultantId(consultantId)
                .productId(productId)
                .processMean(ProcessMean.PHONE)
                .largeArea("커리어 상담")
                .detailArea("웹")
                .reservationAT(LocalDateTime.now().plusDays(1))
                .content("이직을 준비하고 있는데 어떤 것을 준비해야 할까요?")
                .attachedFileList(attachedFileList)
                .cost(10000)
                .build();
    }

    private Consulter getConsulter() {
        return Consulter.builder()
                .id(2L)
                .loginId("consulter@example.com")
                .name("내담자1")
                .role(RoleType.ROLE_CONSULTER)
                .build();
    }

    private Consultation getConsultation(Consulter consulter) {
        return Consultation.builder()
                .consulter(consulter)
                .reservedItemList(new ArrayList<>())
                .canceledItemList(new ArrayList<>())
                .build();
    }

    private Consultant getConsultant() {
        return Consultant.builder()
                .id(3L)
                .loginId("consultant@example.com")
                .name("상담자1")
                .role(RoleType.ROLE_CONSULTANT)
                .occupation("백엔드 개발자")
                .career(5)
                .build();
    }



    public List<BaseFile> convertToBaseFile(List<MultipartFile> attachedFileList) {
        List<BaseFile> fileList = new ArrayList<>();

        attachedFileList.stream().forEach(attachedFile -> {
            fileList.add(
                    BaseFile.builder()
                            .storedName(attachedFile.getName() + "random")
                            .originName(attachedFile.getName())
                            .fileUrl("/consultations")
                            .build());
        });
        return fileList;
    }
}
