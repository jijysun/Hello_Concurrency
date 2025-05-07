package Concurrency_Project.Hello_Concurrency.user.Repository;

import Concurrency_Project.Hello_Concurrency.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
