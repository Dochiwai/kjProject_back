package kj.travel.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Attach {

    @Id @GeneratedValue
    @Column(name="ATTACH_Id")
    private Long id;

    @Column(name="ATTACH_UUID")
    private Long attachUuid;
    private String url;
    private String realname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
