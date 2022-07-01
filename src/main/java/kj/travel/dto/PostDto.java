package kj.travel.dto;

import kj.travel.domain.AttachPost;
import kj.travel.domain.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private List<String> url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostDto createPostDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        if(board.getAttach() != null){
            for(int i = 0; i < board.getAttach().size(); i++){
                this.url.add(board.getAttach().get(i).getUrl());
            }
        }
        this.createdAt = board.getCreatedAt();
        this.updatedAt = board.getUpdatedAt();
        return this;
    }
}
