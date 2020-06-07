package com.example.spring_lessons.service;

import java.util.List;

import com.example.spring_lessons.entity.User;

public interface RestService {

    //1件登録
    public boolean insert(User user);

    //1件検索
    public User selectOne(String userId);

    //全件検索
    public List<User> selectMany();

    //1件更新
    public boolean update (User user);

    //1件削除
    public boolean delete(String userId);
    
}