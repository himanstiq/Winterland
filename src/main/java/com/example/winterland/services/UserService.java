package com.example.winterland.services;

import com.example.winterland.entities.UserEntity;
import com.example.winterland.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.winterland.Dto.UserDTO;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity createUser(UserEntity user) {
        if(userRepo.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        return userRepo.save(user); // default method in user repo
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

    public UserDTO findByEmailAndName(String email, String username) {
        Optional<UserEntity> userEntity = userRepo.findByEmailAndName(email, username);
        UserDTO userDTO = new UserDTO(); // because this obj is not needed elsewherre so no beans
        if (userEntity.isPresent()) {
            userDTO.setId(userEntity.get().getId());
            userDTO.setName(userEntity.get().getName());
            userDTO.setEmail(userEntity.get().getEmail());
        }

        return userDTO;
    }
}


