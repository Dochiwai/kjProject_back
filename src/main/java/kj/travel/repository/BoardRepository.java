package kj.travel.repository;

import kj.travel.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public Board findOne(Long id){
        Board board = em.createQuery("select b from Board b join fetch Attach a on b.id = a.attachUuid",Board.class)
                .getSingleResult();
        return board;
    }

    public List<Board> findAll(){
        List<Board> findBoardList = em.createQuery("select b from Board b", Board.class)
                .getResultList();
        return findBoardList;
    }

    public List<Board> findByTitle(String title){
        List<Board> findBoardList = em.createQuery("select b from Board b where b.title like concat('%',:title,'%')", Board.class)
                .setParameter("title", title)
                .getResultList();
        return findBoardList;
    }

    public List<Board> findByCreatedUser(String nickname){
        List<Board> findBoardList = em.createQuery("select b from Board b where b.createdUser =: nickname", Board.class)
                .setParameter("nickname", nickname)
                .getResultList();
        return findBoardList;
    }


}
