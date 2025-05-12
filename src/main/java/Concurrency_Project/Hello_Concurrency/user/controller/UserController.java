package Concurrency_Project.Hello_Concurrency.user.controller;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.ApiResponse;
import Concurrency_Project.Hello_Concurrency.user.dto.UserRequestDto;
import Concurrency_Project.Hello_Concurrency.user.dto.UserResponseDto;
import Concurrency_Project.Hello_Concurrency.user.entity.User;
import Concurrency_Project.Hello_Concurrency.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    // Response API 통일하기

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User userByUserId = userService.getUserByUserId(userId);
        return ResponseEntity.ok(userByUserId);
    }

    @PostMapping("")
    public ResponseEntity<UserRequestDto.SignInRequestDto> createUser(@RequestBody UserRequestDto.SignInRequestDto signInRequestDto) {
        boolean save = userService.signIn(signInRequestDto);

        if (save) {
            return ResponseEntity.ok(signInRequestDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(signInRequestDto);
        }
    }

    @PostMapping("/validate")
    public ApiResponse<UserResponseDto> validateSignIn (@RequestBody UserRequestDto.SignInValidateDto signInValidateDto) {

        return ApiResponse.onSuccess(, Su)


    }


    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto.UpdateRequestDto updateRequestDto) {
        userService.updateUser(userId, updateRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }


}
