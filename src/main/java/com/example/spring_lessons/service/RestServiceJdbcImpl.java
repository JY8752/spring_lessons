package com.example.spring_lessons.service;

import java.util.List;

import com.example.spring_lessons.entity.User;
import com.example.spring_lessons.repository.jdbc.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RestServiceJdbcImpl implements RestService {

    @Autowired
    @Qualifier("UserDaoJdbcImpl")
    UserDao dao;

    @Override
    public boolean delete(String userId) {
        int result = dao.deleteOne(userId);
        if(result == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insert(User user) {
        int result = dao.insertOne(user);
        if(result == 0){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<User> selectMany() {
        return dao.selectMany();
    }

    @Override
    public User selectOne(String userId) {
        return dao.selectOne(userId);
    }

    @Override
    public boolean update(User user) {
        int result = dao.updateOne(user);
        if(result == 0) {
            return false;
        } else {
            return true;
        }
    }
}