package kj.travel.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Board {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User createdUser;

    @Enumerated(EnumType.STRING)
    private BoardType type;
    private String title;
    private String content;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Attach", //조인테이블명
            joinColumns = @JoinColumn(name="BOARD_ID"),  //외래키
            inverseJoinColumns = @JoinColumn(name="ATTACH_UUID") //반대 엔티티의 외래키
    )
    private List<Attach> fileImg;
    private int isDisplay; // 0 삭제 , 1 공개중
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
