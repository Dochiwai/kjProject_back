package kj.travel.repository;

import kj.travel.domain.AttachPost;
import kj.travel.domain.AttachUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachUserRepository {

    private final EntityManager em;

    public Long save(AttachUser attachUser){
        em.persist(attachUser);
        return attachUser.getId();
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
