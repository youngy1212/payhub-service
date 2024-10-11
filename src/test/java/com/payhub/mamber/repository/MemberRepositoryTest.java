package com.payhub.mamber.repository;

import com.payhub.mamber.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testmember() {

        Member member = new Member();
        member.setName("Test User");

        // Member 객체 저장
        Long savedId = memberRepository.save(member);

        // 저장된 Member 객체 조회
        Member foundMember = memberRepository.findById(savedId);

        // 결과 검증
        assertThat(foundMember).isNotNull();
        assertThat(foundMember.getId()).isEqualTo(savedId);
        assertThat(foundMember.getName()).isEqualTo(member.getName());
    }

}