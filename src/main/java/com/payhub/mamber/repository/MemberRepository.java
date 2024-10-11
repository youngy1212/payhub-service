package com.payhub.mamber.repository;

import com.payhub.mamber.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(final Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findById(final Long id) {
        return em.find(Member.class, id);
    }

}
