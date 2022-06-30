package kj.travel.service;


import kj.travel.domain.AttachUser;
import kj.travel.domain.User;
import kj.travel.repository.AttachUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AttachUserService {

    private final AttachUserRepository attachRepository;

    private final S3Service s3Service;


    @Transactional(readOnly = false)
    public void save(User user, MultipartFile file) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String url = s3Service.upload(file,"user/" + now);
        AttachUser attachUser = AttachUser.createAttachUser(user,file.getOriginalFilename(),url,now);
        if(null == user.getAttach() || "".equals(user.getAttach().getUrl())){
            attachRepository.save(attachUser);
        }else{
            attachUser = attachRepository.findOneByUid(user.getUid());
            attachUser.setUrl(url);
            attachUser.setUpdatedAt(now);
        }

    }

}
