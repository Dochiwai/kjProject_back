package kj.travel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="tb_attachpost")
public class AttachPost {

    @Id @GeneratedValue
    @Column(name="ATTACH_Id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board attachUuid;

    private String url;
    private String realname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
