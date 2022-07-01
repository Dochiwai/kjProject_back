package kj.travel.service;

import kj.travel.domain.AttachUser;
import kj.travel.domain.User;
import kj.travel.repository.AttachUserRepository;
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
    public String join(User user){

        String result = "회원가입을 되었습니다.";

        if(findByNickname(user.getNickname()) == 0L){
            return "이미 사용중인 닉네임입니다.";
        }
        if(findByUserId(user.getId()) == 0L){
            return "이미 사용중인 아이디입니다";
        }

        userRepository.save(user);

        return "회원가입을 되었습니다.";
    }

    public User findOne(Long userUid){
        return userRepository.findOne(userUid);
    }

    public List<User> findMembers(){
        return userRepository.findAll();
    }

    public Long findByNickname(String nickname){
        List<User> findUser = userRepository.findByNickname(nickname);
        if(findUser.size() > 0){
            return 0L;
        }else{
            return 1L;
        }
    }   
    
    public Long findByUserId(String id){
        List<User> findUser = userRepository.findByUserId(id);
        if(findUser.size() > 0){
            return 0L;
        }else{
            return 1L;
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
