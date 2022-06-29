package kj.travel.service;


import kj.travel.repository.AttachUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AttachUserService {

    private final AttachUserRepository attachRepository;

    public void save(){

    }

}
