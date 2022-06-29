package kj.travel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="tb_attachuser")
public class AttachUser {

    @Id @GeneratedValue
    @Column(name="ATTACH_Id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_uuid")
    private User user;

    private String url;
    private String realname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void setMember(User user){
        this.user = user;
    }

}
