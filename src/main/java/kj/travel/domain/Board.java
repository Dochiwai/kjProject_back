package kj.travel.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name="tb_board")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Board {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private User createdUser;

    @Enumerated(EnumType.STRING)
    private BoardType type;

    private String title;
    private String content;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "attachUuid")
    private List<AttachPost> attach = new ArrayList<>();

    private int isDisplay; // 0 삭제 , 1 공개중
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
