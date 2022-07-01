package kj.travel.controller;

import kj.travel.domain.User;
import kj.travel.service.AttachUserService;
import kj.travel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AttachUserService attachUserService;

    @PostMapping("/user/save")
    public String userSave(@RequestParam("id")String id ,@RequestParam("pw")String pw ,@RequestParam("nickname")String nickname){
        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setNickname(nickname);
        user.setStatus(1);

        String result = userService.join(user);
        return result;
    }

    @PostMapping("/user/profileUpload")
    public String profileUpload(@RequestParam("uid")Long uid, @RequestParam("file")MultipartFile file) throws IOException {
        User user = userService.findOne(uid);
        attachUserService.save(user,file);
        return "good";
    }

    @PostMapping("/user/myInfo")
    public User user(@RequestParam("uid")Long id){
        return userService.findOne(id);
    }

    @PostMapping("/user/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

}
