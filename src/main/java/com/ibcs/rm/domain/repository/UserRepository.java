package com.ibcs.rm.domain.repository;

import com.ibcs.rm.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT u FROM User u WHERE u.userName = :userName")
    Optional<User> findUserByUserNameNative(@Param("userName") String userName);
}
