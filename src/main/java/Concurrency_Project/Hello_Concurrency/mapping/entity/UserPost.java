package Concurrency_Project.Hello_Concurrency.mapping.entity;

import Concurrency_Project.Hello_Concurrency.common.entity.BaseEntity;
import Concurrency_Project.Hello_Concurrency.post.entity.Post;
import Concurrency_Project.Hello_Concurrency.user.entity.User;
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
public class UserPost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
