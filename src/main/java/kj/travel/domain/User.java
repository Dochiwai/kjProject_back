package kj.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
