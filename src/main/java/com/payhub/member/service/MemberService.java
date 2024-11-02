package com.payhub.member.service;

import com.payhub.member.entity.Member;
import com.payhub.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /* 회원 가입 */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getMemberId();
    }

    private void validateDuplicateMember(Member member) {

        List<Member> findMember = memberRepository.findByName(member.getName());
        if (!findMember.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /* 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        Member member = memberRepository.findById(memberId);

        if (member == null) {
            throw new IllegalStateException("존재하지 않는 회원입니다."); // 여기서 예외 처리
        }

        return member;
    }

    @Transactional
    public void updateMember(Member member) {
        Member findMember = memberRepository.findById(member.getMemberId());

        findMember.setName(member.getName());
        findMember.setAddress(member.getAddress());
        findMember.setPhone(member.getPhone());
    }

    public void deleteMember(Long memberId) {
        Member findMember = memberRepository.findById(memberId);

        if (findMember == null) {
            throw new IllegalStateException("존재하지 않는 회원입니다."); // 여기서 예외 처리
        }
        memberRepository.delete(findMember);
    }
}
