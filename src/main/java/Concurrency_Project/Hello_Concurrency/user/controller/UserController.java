package Concurrency_Project.Hello_Concurrency.user.controller;

import Concurrency_Project.Hello_Concurrency.user.Repository.UserRepository;
import Concurrency_Project.Hello_Concurrency.user.dto.req.SignInRequestDto;
import Concurrency_Project.Hello_Concurrency.user.dto.req.UpdateRequestDto;
import Concurrency_Project.Hello_Concurrency.user.entity.SocialLogin;
import Concurrency_Project.Hello_Concurrency.user.entity.User;
import Concurrency_Project.Hello_Concurrency.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CompositeType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User userByUserId = userService.getUserByUserId(userId);
        return ResponseEntity.ok(userByUserId);
    }

    @PostMapping("")
    public ResponseEntity<SignInRequestDto> createUser(@RequestBody SignInRequestDto signInRequestDto) {
        boolean save = userService.signIn(signInRequestDto);

        if (save) {
            return ResponseEntity.ok(signInRequestDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(signInRequestDto);
        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UpdateRequestDto updateRequestDto) {
        userService.updateUser(userId, updateRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }




}
