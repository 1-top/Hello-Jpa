package com.harrybro.jpa.practice;

import com.harrybro.jpa.practice.domain.Delivery;
import com.harrybro.jpa.practice.domain.Member;
import com.harrybro.jpa.practice.domain.Order;
import com.harrybro.jpa.practice.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    }

}
