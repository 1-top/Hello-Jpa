//package com.harrybro.jpa.oneway.onetoone;
//
//import javax.persistence.*;
//
////@Entity
//public class Member {
//
//    /**
//     * 1 대 1 연관 관계일 때는 주인을 아무 곳에나 설정해줘도 무방하다.
//     */
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JoinColumn(name = "team_id")
//    @OneToOne
//    private Team team;
//
//}
