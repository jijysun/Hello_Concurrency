package Concurrency_Project.Hello_Concurrency.user.entity;

import Concurrency_Project.Hello_Concurrency.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // 따로 할당하지 않아도, DB가 알아서 AUTO_INCREMENT
    private Long id;


    @Column(nullable = false, unique = true, length = 40)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 20)
    private String username;

    @Enumerated(EnumType.STRING)
    private SocialLogin socialLogin;

    private Integer postCount = 0;

    private Boolean inactive = false;





}
