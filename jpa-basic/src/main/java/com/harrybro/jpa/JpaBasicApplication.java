package com.harrybro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaBasicApplication {

    // JPA의 모든 데이터 변경은 Transaction 안에서 실행된다.
    // [영속성 컨텍스트의 이점]
    //  1차 캐시
    //  동일성(identity) 보장 (영속 엔터티의 동일성을 보장해준다)
    //  트랜잭션을 지원하는 쓰기 지연(Transactional write-behind): 쓰기 지연 Sql 저장소에 저장했다가, commit하는 순간에 쓴다.
    //  변경 감지(Dirty Checking)
    //  지연 로딩(Lazy Loading)

    // [플러시]
    //  영속성 컨텍스트의 변경 내용을 데이터베이스에 반영
    // [플러시 발생]
    //  변경 감지
    //  수정된 엔터티 쓰기 지연  SQL 저장소에 등록
    //  쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송(등록, 수정, 삭제 쿼리)
    // [영속성 컨텍스트를 플러시 하는 방법]
    //  em.flush();: 직접 호출
    //  transaction commit: 플러시 자동 호출
    //  JPQL 쿼리 실행: 플러시 자동 호출
    // [플러시 모드 옵션]
    //  em.setFlushMode(FlushModeType.COMMIT)
    //  FlushModeType.AUTO - commit이나 query를 실행할 때 플러시 (기본값) // 그냥 기본값으로 사용 권장.
    //  FlushModeType.COMMIT - commit할 때만 플러시
    // [플러시 특성]
    //  영속성 컨텍스트를 비우지 않는다.
    //  영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화한다.
    //  트랜잭션이라는 작업 단위가 중요하다. -> 커밋 직전에만 동기화 시키면 된다.

    // [준영속 상태]
    //  영속상태를 비영속 상태로 바꾼 것을 말한다.
    //  영속 상태의 엔터티가 영속성 컨텍스트에서 분리 된 것(detached)
    //  영속성 컨텍스트가 제공하는 기능을 사용하지 못한다.
    //  commit을해도 DB에 반영이 되지 않는다.(SQL문이 안 날라감)
    // [준영속 상태로 만드는 방법]
    // em.detach(entity) - 특정 엔터티만 준영속 상태로 전환한다.
    // em.clear() - 영속성 컨텍스트를 전부 초기화한다.
    // em.close() - 영속성 컨텍스트를 종료한다.

    public static void main(String[] args) {
        // EntityManagerFactory는 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-basic");
        // EntityManager는 Thread간에 공유X (사용하고 버려야한다.)
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
//            // Save
//            Member member1 = new Member().setName("Tester1");
//            em.persist(member1); // 영속성 컨텍스트에 저장한다. (1차 캐시에 저장한다)
//            // Select
//            Member findMember = em.find(Member.class, 1L);
//            em.persist(new Team().setName("HelloTeam"));
//            Team team = em.find(Team.class, 1L);
//            findMember.setTeam(team);
//            // Delete
////            em.remove(findMember);
//            transaction.commit(); // commit을 해줘야지 DB에 반영이 된다.
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        entityManagerFactory.close();
    }

}
