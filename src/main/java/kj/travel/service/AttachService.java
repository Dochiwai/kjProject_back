package kj.travel.service;


import kj.travel.repository.AttachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AttachService {

    private final AttachRepository attachRepository;

    public void save(){

    }

}
