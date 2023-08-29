package com.userapi2.userappbackendrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name="person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "user Name cannot be blank")
    private String username;
    @Email(message = "provide valid email Id")
    @NotBlank(message = "Email cannot be blank")
    private  String email;
    @NotBlank(message = "password cannot be blank")
    private String password;
    @NotBlank(message = "please enter your full name")
    @Column(name="full_name")
    private String fullName;
    private int age;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,mappedBy = "person")
    private List<DataClass> list;

}
