package kj.travel.repository;

import kj.travel.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long uid){
        User user = em.find(User.class, uid);
        return user;
    }

    public List<User> findAll(){
        List<User> userList = em.createQuery("select u from User u", User.class)
                .getResultList();
        return userList;
    }

    public User findByNickname(String nickname) {
        User findUser = em.createQuery("select u from User u where u.nickname =:nickname", User.class)
                .setParameter("nickname", nickname)
                .getSingleResult();
        return findUser;
    }

    public User findByUserId(String uid) {
        User findUser = em.createQuery("select u from User u where u.uid =:uid", User.class)
                .setParameter("uid", uid)
                .getSingleResult();
        return findUser;
    }
}
