package com.example.spring_lessons;

import java.util.List;

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

    @Override
    public int insertOne(User user) throws DataAccessException {
        int rowNumber = jdbc.update("insert into m_user(user_id,"
        + "password,"
        + "user_name"
        + "birthday"
        + "age"
        + "marrige"
        + "role)"
        + "values(?, ?, ?, ?, ?, ?, ?)"
        , user.getUserId()
        , user.getPassword()
        , user.getUserName()
        , user.getBirthday()
        , user.getAge()
        , user.isMarrige()
        , user.getRole());

        return rowNumber;
    }

    @Override
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