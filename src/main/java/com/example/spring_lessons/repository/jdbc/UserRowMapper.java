package com.example.spring_lessons.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.spring_lessons.entity.User;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int RowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        user.setPassword(rs.getString("password"));
        user.setUserName(rs.getString("user_name"));
        user.setBirthday(rs.getDate("birthday"));
        user.setAge(rs.getInt("age"));
        user.setMarrige(rs.getBoolean("marrige"));
        user.setRole(rs.getString("role"));

        return user;
    }
    
}