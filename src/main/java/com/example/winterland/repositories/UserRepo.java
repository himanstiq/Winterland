package com.example.winterland.repositories;


import com.example.winterland.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByName (String name);
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findAllByEmail(String email);


}

