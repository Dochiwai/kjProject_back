package kj.travel.dto;

import kj.travel.domain.AttachUser;
import kj.travel.domain.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long uid;
    private String pw;
    private String nickname;
    private String email;
    private String nation;
    private String url;
    private int status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDto UserEntityToDto(User user){
        this.pw = user.getPw();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.nation = user.getNation();
        if(null != user.getAttach()){
            this.url = user.getAttach().getUrl();
        }
        this.status = user.getStatus();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();

        return this;
    }

}
