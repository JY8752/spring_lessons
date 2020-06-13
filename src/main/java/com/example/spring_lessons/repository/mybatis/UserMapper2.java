package com.example.spring_lessons.repository.mybatis;

import java.util.List;

import com.example.spring_lessons.entity.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper2 {

    public boolean insert(User user);

    public User selectOne(String userId);

    public List<User> selectMany();

    public boolean updateOne(User user);

    public boolean deleteOne(String userId);
    
    
}