package Concurrency_Project.Hello_Concurrency.user.service;

import Concurrency_Project.Hello_Concurrency.user.Repository.UserRepository;
import Concurrency_Project.Hello_Concurrency.user.dto.req.SignInRequestDto;
import Concurrency_Project.Hello_Concurrency.user.dto.req.UpdateRequestDto;
import Concurrency_Project.Hello_Concurrency.user.entity.SocialLogin;
import Concurrency_Project.Hello_Concurrency.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean signIn(SignInRequestDto signInRequestDto) {

        User user = User.builder()
                .email(signInRequestDto.getEmail())
                .password(signInRequestDto.getPassword())
                .username(signInRequestDto.getUsername())
                .postCount(0)
                .socialLogin(SocialLogin.NORMAL)
                .inactive(false)
                .build();

        userRepository.save(user);

        return true;
    }


    public User getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public void updateUser(Long userId, UpdateRequestDto updateRequestDto) {
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
