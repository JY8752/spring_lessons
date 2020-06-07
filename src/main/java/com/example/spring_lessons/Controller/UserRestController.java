package com.example.spring_lessons.Controller;

import com.example.spring_lessons.service.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    
    @Autowired
    RestService restService;
}