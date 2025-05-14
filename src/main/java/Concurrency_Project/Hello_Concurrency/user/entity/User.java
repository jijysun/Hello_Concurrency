package Concurrency_Project.Hello_Concurrency.user.entity;

import Concurrency_Project.Hello_Concurrency.common.entity.BaseEntity;
import Concurrency_Project.Hello_Concurrency.mapping.entity.UserPost;
import Concurrency_Project.Hello_Concurrency.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET inactive = true WHERE id=?")
@Where(clause = "inactive = false")
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

    private Integer postCount;

    private Boolean inactive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPost> userPosts;

    public void updateUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
