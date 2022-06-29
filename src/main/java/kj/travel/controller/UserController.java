package kj.travel.controller;

import kj.travel.domain.User;
import kj.travel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/save")
    public User userSave(User user){

        Long id = userService.join(user);
        return userService.findOne(id);
    }

}
