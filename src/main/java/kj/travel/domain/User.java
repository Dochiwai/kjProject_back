package kj.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;
    private String pw;
    private String nickname;
    private String name;
    private String email;
    private String phone;
    private String nation;
    @OneToOne
    @JoinTable(name = "Attach", //조인테이블명
            joinColumns = @JoinColumn(name="USER_ID"),  //외래키
            inverseJoinColumns = @JoinColumn(name="ATTACH_UUID") //반대 엔티티의 외래키
    )
    private Attach fileImg;
    private int status; // 0 회원탈퇴 , 1 가입중
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
