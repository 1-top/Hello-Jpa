package com.harrybro.jpa;

import com.harrybro.jpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaBasicApplication {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Member member1 = new Member().setName("Tester1");
        em.persist(member1);

        transaction.commit();
        em.close();
        entityManagerFactory.close();
    }

}
