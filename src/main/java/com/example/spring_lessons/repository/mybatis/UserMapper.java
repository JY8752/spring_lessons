package com.example.spring_lessons.repository.mybatis;

import java.util.List;

import com.example.spring_lessons.entity.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Insert("insert into m_user ("
    + " user_id"
    + ", password"
    + ", user_name"
    + ", birthday"
    + ", age"
    + ", marrige"
    + ", role)"
    + " values("
    + " #{userId}"
    + ", #{password}"
    + ", #{userName}"
    + ", #{birthday}"
    + ", #{age}"
    + ", #{marrige}"
    + ", #{role})")
    public boolean insert(User user);

    @Select("select user_id as userId, password, user_name as userName, birthday, age, marrige, role"
        + " from m_user where user_id = #{userId}")
    public User selectOne(String userId);

    @Select("select user_id as userId, password, user_name as userName, birthday, age, marrige, role from m_user")
    public List<User> selectMany();

    @Update("update m_user set password = #{password}"
    + " user_name = #{userName}"
    + " birthday = #{birthday}"
    + " age = #{age}"
    + " marrige = #{marrige}"
    + " where user_id = #{userId}")
    public boolean updateOne(User user);

    @Delete("delete from m_user where user_id = #{userId}")
    public boolean deleteOne(String userId);
    
}