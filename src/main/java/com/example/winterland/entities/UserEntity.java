package com.example.winterland.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    @Email(message = "Enter a valid address")
    private String email;
    @Size(min = 8, max=15)
    private String password;

    //    public String setName(String name) {
//        this.name = name;
//    }
//    public String getName(){
//        return this.name;
//    }

    // for this we will use LOMBOK+ -> @Getter, @Setter etc

}
