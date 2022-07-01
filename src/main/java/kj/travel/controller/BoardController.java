package kj.travel.controller;

import kj.travel.domain.AttachPost;
import kj.travel.domain.Board;
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
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final AttachPostService attachPostService;

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

}
