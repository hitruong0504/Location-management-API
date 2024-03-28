package com.example.locationmanagementapi.repository;

import com.example.locationmanagementapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailAndPassword(String email, String password);

    UserEntity findByEmail(String email);
}
