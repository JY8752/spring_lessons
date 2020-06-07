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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insert(User user) {
        // TODO Auto-generated method stub
        return false;
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
        // TODO Auto-generated method stub
        return false;
    }
}