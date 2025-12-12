package com.studentmanagement.reposistory;



import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;


import com.studentmanagement.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByUsername(String username);
}
