package Concurrency_Project.Hello_Concurrency.user.service;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status.ErrorStatus;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.exception.handler.UserHandler;
import Concurrency_Project.Hello_Concurrency.user.Repository.UserRepository;
import Concurrency_Project.Hello_Concurrency.user.dto.UserRequestDto;
import Concurrency_Project.Hello_Concurrency.user.entity.SocialLogin;
import Concurrency_Project.Hello_Concurrency.user.entity.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class  UserService {

    private final UserRepository userRepository;

    public void signIn(UserRequestDto.SignInRequestDto signInRequestDto) {

        User user = User.builder()
                .email(signInRequestDto.getEmail())
                .password(signInRequestDto.getPassword())
                .username(signInRequestDto.getUsername())
                .postCount(0)
                .socialLogin(SocialLogin.NORMAL)
                .inactive(false)
                .build();

        userRepository.save(user);
        
        // if 중복으로 인한 오류 발생 시 Unique Exception 처리
    }

    public void validateSignIn(UserRequestDto.SignInValidateDto signInValidateDto) {

        // 이메일, 닉네임 중복 검사
        Optional<User> userByEmail = userRepository.findUserByEmail(signInValidateDto.getEmail());
        Optional<User> userByUsername = userRepository.findUserByUsername(signInValidateDto.getUsername());

        if (userByEmail.isPresent()) {
            throw new UserHandler(ErrorStatus.EMAIL_ALREADY_EXIST); // 이메일 중복 Exception
        }
        if (userByUsername.isPresent()) {
            throw new UserHandler(ErrorStatus.NICKNAME_ALREADY_EXIST); // 닉네임 중복 Exception
        }

    }


    public User getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public void updateUser(Long userId, UserRequestDto.UpdateRequestDto updateRequestDto) {
        User user = getUserByUserId(userId);
        if (user != null) {
            user.updateUsername(updateRequestDto.getUsername());
        }
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = getUserByUserId(userId);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
