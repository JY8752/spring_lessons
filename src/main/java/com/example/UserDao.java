package com.example;

import java.util.List;

import com.example.spring_lessons.User;

import org.springframework.dao.DataAccessException;

public interface UserDao {
    
    public int count() throws DataAccessException;

    public int insertOne(User user) throws DataAccessException;

    public User selectOne(String userId) throws DataAccessException;

    public List<User> selectMany() throws DataAccessException;

    public int updateOne(User user) throws DataAccessException;

    public int deleteOne(String userId) throws DataAccessException;

    public void userCsvOut() throws DataAccessException;
}