package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name",nullable=false,length = 40)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 40)
    private String lastName;
    @Column(nullable = false,length = 40,unique = true)
    private String email;
    @Column(nullable = false,length = 40)
    private String password;
    private boolean enabled;
}
