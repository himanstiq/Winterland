package com.example.winterland.services;

import com.example.winterland.entities.UserEntity;
import com.example.winterland.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    // constructor injection (preferred)
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // NOTE: use the correct type name (UserEntity, not userEntity)
    public UserEntity createUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

public List<UserEntity> findAll() {
    return userRepo.findAll();
}

    public Optional<UserEntity> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Optional<UserEntity> findByName(String name) {
        return userRepo.findByName(name);
    }

    public List<UserEntity> findAllByEmail(String email) {
        return userRepo.findAllByEmail(email);
    }
}


