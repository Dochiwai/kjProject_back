package kj.travel.service;


import kj.travel.domain.AttachPost;
import kj.travel.domain.Board;
import kj.travel.repository.AttachPostRepository;
import kj.travel.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AttachPostService {

    private final AttachPostRepository attachRepository;
    private final BoardRepository boardRepository;
    private final S3Service s3Service;

    @Transactional(readOnly = false)
    public void save(Long boardId, List<MultipartFile> files) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        for(int i = 0; i < files.size(); i++) {
            Board board = boardRepository.findOne(boardId);
            String url = s3Service.upload(files.get(i), "board/" + now);
            AttachPost attachPost = AttachPost.createAttachPost(board, files.get(i).getOriginalFilename(), url, now);
            attachRepository.save(attachPost);
        }
    }



}
