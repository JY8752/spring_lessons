package com.example.spring_lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserDao dao;

    public boolean insert(User user){
        int rowNumber = dao.insertOne(user);

        boolean result = false;

        if(rowNumber > 0){
            result = true;
        }

        return result;
    }
}