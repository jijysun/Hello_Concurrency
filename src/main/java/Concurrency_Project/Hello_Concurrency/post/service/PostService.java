package Concurrency_Project.Hello_Concurrency.post.service;

import Concurrency_Project.Hello_Concurrency.post.dto.PostRequestDto;
import Concurrency_Project.Hello_Concurrency.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public void createPost(PostRequestDto.UploadRequestDto uploadRequestDto){



    }
}
