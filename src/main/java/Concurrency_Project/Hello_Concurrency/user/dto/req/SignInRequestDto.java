package Concurrency_Project.Hello_Concurrency.user.dto.req;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInRequestDto {

    private String email;
    private String password;
    private String username;
}
