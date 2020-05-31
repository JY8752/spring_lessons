package com.example.spring_lessons.repository.jdbc;

import java.util.List;

import com.example.spring_lessons.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("UserDaoJdbcImpl4")
public class UserDaoJdbcImpl4 extends UserDaoJdbcImpl{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<User> selectMany(){
        String sql = "select * from m_user";

        UserResultSetExtractor extractor = new UserResultSetExtractor();

        return jdbc.query(sql, extractor);
    }
    
}