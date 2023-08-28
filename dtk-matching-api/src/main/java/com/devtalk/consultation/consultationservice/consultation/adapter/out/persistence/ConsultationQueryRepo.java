package com.devtalk.consultation.consultationservice.consultation.adapter.out.persistence;

import com.devtalk.consultation.consultationservice.consultation.application.port.out.repository.ConsultationQueryableRepo;
import com.devtalk.consultation.consultationservice.consultation.domain.consultation.Consultation;
import com.devtalk.consultation.consultationservice.consultation.domain.consultation.ConsultationCancellation;
import com.devtalk.consultation.consultationservice.consultation.domain.consultation.QConsultationCancellation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.devtalk.consultation.consultationservice.consultation.domain.consultation.ProcessStatus.*;
import static com.devtalk.consultation.consultationservice.consultation.domain.consultation.QConsultation.*;
import static com.devtalk.consultation.consultationservice.consultation.domain.consultation.QConsultationCancellation.*;

@Repository
@RequiredArgsConstructor
public class ConsultationQueryRepo implements ConsultationQueryableRepo {

    private final JPAQueryFactory queryFactory;

    @Override
    public boolean existsByProductIdInReservedItem(Long productId) {
        return queryFactory
                .select(consultation.productId)
                .from(consultation)
                .where(consultation.productId.eq(productId)
                        .and(consultation.status.in(ACCEPTED, PAID)))
                .fetchFirst() != null;
    }

    @Override
    public Optional<Consultation> findByIdWithConsulterId(Long consultationId, Long consulterId) {
        return Optional.ofNullable(
                queryFactory
                .select(consultation)
                .from(consultation)
                .where(consultation.id.eq(consultationId)
                        .and(consultation.consulterId.eq(consulterId)))
                .fetchFirst());
    }

    @Override
    public Optional<Consultation> findByIdWithConsultantId(Long consultationId, Long consultantId) {
        return Optional.ofNullable(
                queryFactory
                        .select(consultation)
                        .from(consultation)
                        .where(consultation.id.eq(consultationId)
                                .and(consultation.consultantId.eq(consultantId)))
                        .fetchFirst());
    }

    @Override
    public List<Consultation> findAllByConsulterId(Long consulterId) {
        return queryFactory
                .select(consultation)
                .from(consultation)
                .where(consultation.consulterId.eq(consulterId))
                .fetch();
    }

    @Override
    public Optional<ConsultationCancellation> findCancellationByConsultationId(Long consultationId, Long consulterId) {
        return Optional.ofNullable(
                queryFactory
                .select(consultationCancellation)
                .from(consultationCancellation)
                        .join(consultationCancellation.consultation, consultation)
                .where(consultationCancellation.consultation.id.eq(consultationId).and(
                        consultation.consulterId.eq(consulterId)
                ))
                .fetchFirst());
    }

}
