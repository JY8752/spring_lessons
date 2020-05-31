package com.example.spring_lessons;

import java.util.List;

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

    public int count(){
        return dao.count();
    }

    public List<User> selectMany(){
        return dao.selectMany();
    }

    public User selectOne(String userId){
        return dao.selectOne(userId);
    }

    public boolean updateOne(User user){
        int rowNumber = dao.updateOne(user);

        boolean result = false;
        if(rowNumber > 0){
            result = true;
        }
        return result;
    }
}