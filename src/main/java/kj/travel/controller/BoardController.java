package kj.travel.controller;

import kj.travel.domain.AttachPost;
import kj.travel.domain.Board;
import kj.travel.dto.PostDto;
import kj.travel.exception.BoardException;
import kj.travel.service.AttachPostService;
import kj.travel.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final AttachPostService attachPostService;

    /**
     * 게시판 저장
     * @param board
     * @param files
     * @return
     * @throws IOException
     */

    @PostMapping("/board/save")
    public String boardSave(@ModelAttribute("board")Board board , @RequestParam("image")List<MultipartFile> files) throws IOException {
        if(files.size() > 5){
            throw new BoardException("파일이 너무 많습니다.");
        }
        Long boardId = boardService.save(board);
        if(files.size() > 0){
            attachPostService.save(boardId,files);
        }
        return "good";
    }

    /**
     * 게시물 전체 불러오기
     * @return
     */
    @PostMapping("/board/findAll")
    public List<PostDto> boardFindAll(){
        List<Board> boardList = boardService.findAll();
        List<PostDto> dtos = new ArrayList<>();

        for(int i = 0; i < boardList.size(); i++){
            PostDto dto = new PostDto();
            dto.createPostDto(boardList.get(i));
            dtos.add(dto);
        }
        return dtos;
    }

    /**
     * 게시물 상세조회
     * @param id
     * @return
     */
    @PostMapping("/board/detail")
    public PostDto boardFindOne(@RequestParam("uid")Long id){
        Board board = boardService.findOne(id);
        PostDto dto = new PostDto().createPostDto(board);
        return dto;
    }
    
    @PostMapping("/board/edit")
    public String boardEdit(@ModelAttribute("post")PostDto postDto, @RequestParam("image")List<MultipartFile> files){

        return "ㅎㅎ";
    }



}
