package Concurrency_Project.Hello_Concurrency.user.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestDto {

    private String username;
    private String password;

}
