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
    @Column(name="ATTACH_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_uuid")
    private User user;

    private String url;
    private String realname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static AttachUser createAttachUser(User user , String realname,String url ,LocalDateTime createdAt){
        AttachUser attachUser = new AttachUser();
        attachUser.setUser(user);
        attachUser.setRealname(realname);
        attachUser.setUrl(url);
        attachUser.setCreatedAt(createdAt);

        return attachUser;
    }
}
