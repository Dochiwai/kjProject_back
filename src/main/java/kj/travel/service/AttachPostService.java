package kj.travel.service;


import kj.travel.repository.AttachPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AttachPostService {

    private final AttachPostRepository attachRepository;

    public void save(){

    }

}
