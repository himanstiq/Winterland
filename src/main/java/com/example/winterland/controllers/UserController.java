//package com.example.winterland.controllers;
//
//import com.example.winterland.entities.UserEntity;
//import com.example.winterland.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // POST /user
//    @PostMapping
//    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
//        UserEntity user = userService.createUser(userEntity);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//
//    }
//
//    // GET /user
//    @GetMapping
//    public List<UserEntity> findAll() {
//        return userService.findAll();
//    }
//
//    // GET /user/search?email=abc@gmail.com
////    @GetMapping("/search")
////    public List<UserEntity> findAllByEmail(@RequestParam String email) {
////        return userService.findAllByEmail(email);
////    }
//
//    @GetMapping("/{email}")
//    public Optional<UserEntity> findByEmail(@RequestParam String email){
//        return userService.findByEmail(email);
//    }
//
////    @GetMapping("/filter")
////    public List<UserEntity> findAllByEmailAndName(
////            @RequestParam String email,
////            @RequestParam String username) {
////        return userService.findAllByEmailAndName(email, username);
////    }
//
//    //    public Optional<UserEntity> findAllByEmail(@RequestParam String email) {
////        return userService.findByEmail(email);
////    }
//
//    @GetMapping({"/filter"})
//    public UserDTO findAllByEmailAndName(@RequestParam String email, @RequestParam String name) {
//        return this.userService.findByEmailAndName(email, name);
//    }
//}
package com.example.winterland.controllers;

import com.example.winterland.Dto.UserDTO;
import com.example.winterland.entities.UserEntity;
import com.example.winterland.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.createUser(userEntity);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{email}")
    public Optional<UserEntity> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/filter")
    public UserDTO findAllByEmailAndName(@RequestParam String email, @RequestParam String name) {
        return userService.findByEmailAndName(email, name);
    }
}