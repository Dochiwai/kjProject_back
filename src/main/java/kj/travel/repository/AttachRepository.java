package kj.travel.repository;

import kj.travel.domain.Attach;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachRepository {

    private EntityManager em;

    private void save(Attach attach){
        em.persist(attach);
    }

    private void deleteByUUID(Long UUID){
        em.createQuery("delete from Attach a where a.attachUuid =:UUID")
                .setParameter("UUID",UUID);
    }

    private List<Attach> findByUUID(Long uuid){
        List<Attach> attachList = em.createQuery("select a from Attach a where a.attachUuid =:uuid", Attach.class)
                .setParameter("uuid", uuid)
                .getResultList();
        return attachList;
    }

}
