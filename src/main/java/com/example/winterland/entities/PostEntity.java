package com.example.winterland.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @Size(max = 100)
    private String description;
    private String date;
    private String photo;
    private Integer likes;

    @ManyToOne
    private UserEntity user;
}
