package com.myapp.dev.model.mapping;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "EMAIL")
    private String email;

}
