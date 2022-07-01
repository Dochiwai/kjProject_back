package kj.travel.dto;

import kj.travel.domain.AttachPost;
import kj.travel.domain.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private List<AttachPost> attach;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void createPostDto(Board board){
        PostDto dto = PostDto
                .builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .attach(board.getAttach())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

}
