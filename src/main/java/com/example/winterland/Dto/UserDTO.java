package com.example.winterland.Dto;

import lombok.Data;

@Data // gives all getter, setter, constructors etc
public class UserDTO {
    private Long id;
    private String name;
    private String email;
}
