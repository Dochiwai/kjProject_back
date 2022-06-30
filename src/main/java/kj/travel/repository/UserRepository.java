package kj.travel.repository;

import kj.travel.domain.AttachUser;
import kj.travel.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public Long save(User user){
        em.persist(user);
        return user.getUid();
    }

    public User findOne(Long uid){
        User user = em.createQuery(
                "select u from User u left join fetch u.attach where u.uid =:uid",User.class)
                .setParameter("uid",uid)
                .getSingleResult();
        return user;
    }

    public List<User> findAll(){
        List<User> userList = em.createQuery("select u from User u", User.class)
                .getResultList();
        return userList;
    }

    public List<User> findByNickname(String nickname) {
        List<User> findUser = em.createQuery("select u from User u where u.nickname =:nickname", User.class)
                .setParameter("nickname", nickname)
                .getResultList();
        return findUser;
    }

    public List<User> findByUserId(String id) {
        List<User> findUser = em.createQuery("select u from User u where u.id =:id", User.class)
                .setParameter("id", id)
                .getResultList();
        return findUser;
    }
}
