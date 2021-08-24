//package com.harrybro.jpa.oneway.onetomany;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
////@Entity(name = "team")
//public class Team {
//
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    /**
//     * 실무에서는 이런식으로 One인 부분에 JoinColumn을 넣지 않는다...
//     * 실제 디비에는 Member에 fk가 생성된다.
//     * members에 new Member를 넣으면 update문이 Member table에서 일어난다. (member의 team_id에 값이 추가됨.)
//     */
//    @JoinColumn(name = "team_id") // member 테이블에 team_id fk가 생긴다.
//    @OneToMany
//    private List<Member> members = new ArrayList<>();
//
//}
