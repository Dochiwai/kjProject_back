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

    private void save(AttachPost attach){
        em.persist(attach);
    }

    private void deleteByUUID(Long UUID){
        em.createQuery("delete from AttachPost a where a.attachUuid =:UUID")
                .setParameter("UUID",UUID);
    }

    private List<AttachPost> findByUUID(Long uuid){
        List<AttachPost> attachList = em.createQuery("select a from AttachPost a where a.attachUuid =:uuid", AttachPost.class)
                .setParameter("uuid", uuid)
                .getResultList();
        return attachList;
    }

}
