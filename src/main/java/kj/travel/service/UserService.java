package kj.travel.service;

import kj.travel.domain.User;
import kj.travel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = false)
    public Long join(User user){
        userRepository.save(user);
        return user.getUid();
    }

    public User findOne(Long userUid){
        return userRepository.findOne(userUid);
    }

    public List<User> findMembers(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void update(User user) {
         User findUser = userRepository.findOne(user.getUid());
    }

    public String findByNickname(String nickname){
        User findUser = userRepository.findByNickname(nickname);
        if(null != findUser){
            return "이미 존재하는 닉네임입니다.";
        }else{
            return "사용 가능한 닉네임입니다.";
        }
    }   
    
    public String findByUserId(String id){
        User findUser = userRepository.findByUserId(id);
        if(null != findUser){
            return "이미 존재하는 아이디입니다.";
        }else{
            return "사용 가능한 아이디입니다.";
        }
    }
    

}
