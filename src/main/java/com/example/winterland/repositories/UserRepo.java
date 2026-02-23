package com.example.winterland.repositories;


import com.example.winterland.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    // user repo interface extending jpa repo interface so that we can take less methods that are required only not all

    Optional<UserEntity> findByName (String name);
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findAllByEmail(String email);

    Optional <UserEntity> findByEmailAndName(String email, String username);
    Boolean existsByEmail(String email);
    // write methods name here in camel case because of jpql




}

