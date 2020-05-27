package com.example.spring_lessons;

import java.util.List;

import com.example.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJdbcImpl implements UserDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int count() throws DataAccessException {
        return 0;
    }

    public int insertOne(User user) throws DataAccessException {
        return 0;
    }

    public User selectOne(String userId) throws DataAccessException {
        return null;
    }

    public List<User> selectMany() throws DataAccessException {
        return null;
    }

    public int updateOne(User user) throws DataAccessException {
        return 0;
    }

    public int deleteOne(String userId) throws DataAccessException {
        return 0;
    }

    public void userCsvOut() throws DataAccessException {
        
    }
    
}