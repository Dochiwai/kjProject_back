package kj.travel.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="tb_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_uuid")
    private Long uid;

    private String email;
    private String pw;
    private String nickname;
    private String nation;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user")
    private AttachUser attach;

    private int status; // 0 회원탈퇴 , 1 가입중
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
