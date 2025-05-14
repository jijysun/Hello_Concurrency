package Concurrency_Project.Hello_Concurrency.post.repository;

import Concurrency_Project.Hello_Concurrency.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


}
