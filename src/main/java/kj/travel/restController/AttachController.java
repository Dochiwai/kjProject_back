package kj.travel.restController;

import kj.travel.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AttachController {

    private final S3Service s3Service;

    @PostMapping("/iamges")
    public String upload(@RequestParam("image")MultipartFile multipartFile)throws IOException {

        s3Service.upload(multipartFile,"static");
        return "good";
    }

}
