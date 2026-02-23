package com.example.winterland.services;

import com.example.winterland.entities.PostEntity;
import com.example.winterland.repositories.PostRepo;
import com.example.winterland.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    public PostEntity createPost(PostEntity postdata) {
        if (postdata == null || postdata.getUser() == null) {
            return null;
        }
        Long userId = postdata.getUser().getId();
        if (userRepo.findById(userId).isPresent()) {
            return postRepo.save(postdata);
        }
        return null;
    }
}