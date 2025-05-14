package Concurrency_Project.Hello_Concurrency.post.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResponseDto {
        private String title; // 하나 반환하는 데 굳이..?
    }
}
