package com.example.spring_lessons.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {

    private String userId;

    private String password;

    private String userName;

    private Date birthday;

    private int age;

    private boolean marrige;

    private String role;
    
}