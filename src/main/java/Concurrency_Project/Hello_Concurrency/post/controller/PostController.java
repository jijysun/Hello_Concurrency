package Concurrency_Project.Hello_Concurrency.post.controller;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.ApiResponse;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status.SuccessStatus;
import Concurrency_Project.Hello_Concurrency.post.dto.PostRequestDto;
import Concurrency_Project.Hello_Concurrency.post.entity.Post;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/")
    public ApiResponse<?> displayPosts (){
        return ApiResponse.onSuccess("ok", SuccessStatus._OK);
    }

    @PostMapping("/")
    public ApiResponse<?> addPost(@RequestBody PostRequestDto.UploadRequestDto uploadRequestDto){

        return ApiResponse.onSuccess("ok", SuccessStatus._CREATE_SUCCESS);
    }


}
