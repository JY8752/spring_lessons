package com.example.spring_lessons.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.spring_lessons.entity.User;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserResultSetExtractor implements ResultSetExtractor<List<User>>{
    
    @Override
    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException{
        List<User> userList = new ArrayList<>();

        while(rs.next()){
            User user = new User();
            user.setUserId(rs.getString("user_id"));
            user.setPassword(rs.getString("password"));
            user.setUserName(rs.getString("user_name"));
            user.setBirthday(rs.getDate("birthday"));
            user.setAge(rs.getInt("age"));
            user.setMarrige(rs.getBoolean("marrige"));
            user.setRole(rs.getString("role"));

            userList.add(user);
        }

        if(userList.size() == 0){
            throw new EmptyResultDataAccessException(1);
        }
        return userList;
    }
}