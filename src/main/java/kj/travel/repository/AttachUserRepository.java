package kj.travel.repository;

import kj.travel.domain.AttachPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachUserRepository {

    private EntityManager em;

    private void save(AttachPost attach){
        em.persist(attach);
    }

    private void deleteByUUID(Long UUID){
        em.createQuery("delete from AttachUser a where a.user.uid =:UUID")
                .setParameter("UUID",UUID);
    }

    private List<AttachPost> findByUUID(Long uuid){
        List<AttachPost> attachList = em.createQuery("select a from AttachUser a where a.user.uid =:uuid", AttachPost.class)
                .setParameter("uuid", uuid)
                .getResultList();
        return attachList;
    }

}
