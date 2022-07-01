package kj.travel.service;

import kj.travel.domain.Board;
import kj.travel.exception.BoardException;
import kj.travel.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(Board board){
        LocalDateTime now = LocalDateTime.now();

        Long id = boardRepository.save(board);

        return id;
    }

    public Board findOne(Long id){
        Board findBoard = boardRepository.findOne(id);
        return findBoard;
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public List<Board> findByTitle(String title){
        return boardRepository.findByTitle(title);
    }

    public List<Board> findByCreatedUser(String nickname){
        return boardRepository.findByCreatedUser(nickname);
    }

}
