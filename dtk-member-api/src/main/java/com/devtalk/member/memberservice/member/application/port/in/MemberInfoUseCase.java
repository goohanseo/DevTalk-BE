package com.devtalk.member.memberservice.member.application.port.in;

import com.devtalk.member.memberservice.member.application.port.out.dto.MemberRes;

public interface MemberInfoUseCase {
    MemberRes.ConsultantRes findConsultantById(Long consultant);

    MemberRes.ConsulterRes findConsulterById(Long consulter);
    MemberRes.ProfileRes findMemberByEmail(String email);
}
