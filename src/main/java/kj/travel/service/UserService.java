package kj.travel.service;

import kj.travel.domain.AttachUser;
import kj.travel.domain.User;
import kj.travel.dto.UserDto;
import kj.travel.exception.UserException;
import kj.travel.repository.AttachUserRepository;
import kj.travel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = false)
    public void join(User user){

        String result = "회원가입을 되었습니다.";

        if(findByNickname(user.getNickname()) == 0L){
            throw new UserException("이미 사용중인 닉네임입니다");
        }
        if(findByUserId(user.getId()) == 0L){
            throw new UserException("이미 사용중인 아이디입니다");
        }

        userRepository.save(user);
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

    @Transactional(readOnly = false)
    public void userUpdate(UserDto dto) {

        if(findByNickname(dto.getNickname()) == 0L){
            throw new UserException("이미 사용중인 닉네임입니다");
        }
        if(findByUserId(dto.getId()) == 0L){
            throw new UserException("이미 사용중인 아이디입니다");
        }

        User findUser = userRepository.findOne(dto.getUid());
        findUser.setNickname(dto.getNickname());
        findUser.setPw(dto.getPw());
        findUser.setEmail(dto.getEmail());
        findUser.setName(dto.getNation());
        findUser.setPhone(dto.getPhone());
        findUser.setUpdatedAt(LocalDateTime.now());
    }
}
