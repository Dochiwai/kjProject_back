package kj.travel.service;

import kj.travel.domain.Board;
import kj.travel.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long join(Board board){
        boardRepository.save(board);
        return board.getId();
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
