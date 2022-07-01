package kj.travel.repository;

import kj.travel.domain.AttachPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachPostRepository {

    private EntityManager em;

    public void save(AttachPost attach){
        em.persist(attach);
    }

    public List<AttachPost> findByUUID(Long uid){
        List<AttachPost> attachList = em.createQuery("select a from AttachPost a where a.board =:uid", AttachPost.class)
                .setParameter("uid", uid)
                .getResultList();
        return attachList;
    }

}
