package com.payhub.member.repository;

import com.payhub.member.entity.Member;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //회원 등록
    public Long save(final Member member) {
        em.persist(member);
        return member.getMemberId();
    }

    //회원 조회
    public Member findById(final Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findByName(final String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
    }

    //리스트 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    //회원 수정
    public Member update(final Member member) {
        return em.merge(member); //TODO: 체크하기
    }

    //회원 삭제
    public void delete(final Member member) {
        em.remove(member);
    }

}
