package Concurrency_Project.Hello_Concurrency.post.controller;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.ApiResponse;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/")
    public ApiResponse<?> displayPosts (){

    }

}
