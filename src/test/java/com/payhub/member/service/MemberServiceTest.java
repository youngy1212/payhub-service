package com.payhub.member.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.payhub.member.entity.Member;
import com.payhub.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);//given

        //then
        assertEquals(member, memberRepository.findById(saveId));
    }

    @Test
    public void 중복_예약() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        //when
        Member member2 = new Member();
        member2.setName("kim");

        //then
        memberService.join(member1);

        //Then
        // 예외 발생 테스트
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

    }

    @Test
    public void 회원_업데이트() throws Exception {

        //given
        Member member1 = new Member();
        member1.setName("kim");
        Long saveId = memberService.join(member1);

        //when
        Member updateMember = new Member();
        updateMember.setMemberId(saveId);
        updateMember.setName("lee");

        memberService.updateMember(updateMember);

        //then
        Member updatedMember = memberRepository.findById(saveId);
        assertEquals("lee", updatedMember.getName());
    }

    @Test
    public void 회원_삭제() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("Kim");
        Long saveId = memberService.join(member1);

        //when
        memberService.deleteMember(saveId);

        //then
        assertThrows(IllegalStateException.class, () -> {
            memberService.findOne(saveId);
        });

    }


}