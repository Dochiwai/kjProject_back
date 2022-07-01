package kj.travel.controller;

import kj.travel.domain.User;
import kj.travel.dto.UserDto;
import kj.travel.exception.UserException;
import kj.travel.service.AttachUserService;
import kj.travel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AttachUserService attachUserService;

    /**
     * 유저 회원 가입
     * @param id
     * @return 성공시 good 실패시 Exception
     */
    @PostMapping("/user/save")
    public String userSave(@RequestParam("id")String id ,@RequestParam("pw")String pw ,@RequestParam("nickname")String nickname){
        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setNickname(nickname);
        user.setStatus(1);
        userService.join(user);
        return "good";
    }

    /**
     * 유저 정보 수정
     * 여기서부턴 DTO 사용
     * @return UserDto
     */
    @PostMapping("/user/edit")
    public String userEdit(@ModelAttribute("UserDto") UserDto dto){
        userService.userUpdate(dto);
        return "good";
    }

    /**
     * 유저 프로필사진 수정
     * @param uid
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/user/profileUpload")
    public String profileUpload(@RequestParam("uid")Long uid, @RequestParam("file")MultipartFile file) throws IOException {
        User user = userService.findOne(uid);
        if(null != user) {
            attachUserService.save(user, file);
        }
        return "good";
    }

    /**
     * 개인 유저정보 확인
     * @param uid
     * @return
     */
    @PostMapping("/user/myInfo")
    public UserDto user(@RequestParam("uid")Long uid){
        User findUser = userService.findOne(uid);
        UserDto dto = new UserDto();
        return dto.UserEntityToDto(findUser);
    }

    /**
     * 전체 유저정보 확인
     * @return
     */
    @PostMapping("/user/findAll")
    public List<UserDto> findAll(){
        List<User> findUsers = userService.findAll();
        List<UserDto> dtos = new ArrayList<>();
        for(int i = 0; i < findUsers.size(); i++){
            dtos.get(i).UserEntityToDto(findUsers.get(i));
        }
        return dtos;
    }

}
