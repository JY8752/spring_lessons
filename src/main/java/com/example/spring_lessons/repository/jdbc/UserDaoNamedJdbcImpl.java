package com.example.spring_lessons.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.spring_lessons.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository("UserDaoNamedJdbcImpl")
public class UserDaoNamedJdbcImpl implements UserDao{
    
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    //件数を取得する
    @Override
    public int count() {
        String sql = "select count(*) from m_user";

        // パラメータの生成
        SqlParameterSource params = new MapSqlParameterSource();

        return jdbc.queryForObject(sql, params, Integer.class);
    }

    //Userテーブルに１件データを登録する
    @Override
    public int insertOne(User user) {
        String sql = "insert into m_user(user_id,"
        + "password,"
        + "user_name,"
        + "birthday,"
        + "age,"
        + "marrige,"
        + "role)"
        + "values(:userId,"
        + ":password, "
        + ":userName, "
        + ":birthday, "
        + ":age, "
        + ":marrige, "
        + ":role)";
        
        //パラメーターの設定
        SqlParameterSource params = new MapSqlParameterSource()
            .addValue("userId", user.getUserId())
            .addValue("password", user.getPassword())
            .addValue("userName", user.getUserName())
            .addValue("birthday", user.getBirthday())
            .addValue("age", user.getAge())
            .addValue("marrige", user.isMarrige())
            .addValue("role", user.getRole());

        //SQL実行
        return jdbc.update(sql, params);
    }

    @Override
    public User selectOne(String userId) {
        String sql = "select * from m_user where user_id = :userId";
        
        //パラメーター
        SqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);

        //SQL実行
        Map<String, Object> map = jdbc.queryForMap(sql, params);

        User user = new User();

        user.setUserId((String)map.get("user_id"));
        user.setPassword((String)map.get("password"));
        user.setUserName((String)map.get("user_name"));
        user.setBirthday((Date)map.get("birthday"));
        user.setAge((Integer)map.get("age"));
        user.setMarrige((Boolean)map.get("marrige"));
        user.setRole((String)map.get("role"));

        return user;
    }

    @Override
    public List<User> selectMany() {
        String sql = "select * from m_user";

        //パラメーター
        SqlParameterSource params = new MapSqlParameterSource();

        //SQL実行
        List<Map<String, Object>> getList = jdbc.queryForList(sql, params);

        List<User> userList = new ArrayList<>();

        //ループ
        for(Map<String, Object> map : getList){
            User user = new User();
            user.setUserId((String)map.get("user_id"));
            user.setPassword((String)map.get("password"));
            user.setUserName((String)map.get("user_name"));
            user.setBirthday((Date)map.get("birthday"));
            user.setAge((Integer)map.get("age"));
            user.setMarrige((Boolean)map.get("marrige"));
            user.setRole((String)map.get("role"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public int updateOne(User user) {
        String sql = "update m_user"
        + " set"
        + " password = :password,"
        + " user_name = userName,"
        + " birthday = :birthday,"
        + " age = :age,"
        + " marrige = :marrige"
        + " where user_id = :userId";

        //パラメーター
        SqlParameterSource params = new MapSqlParameterSource()
            .addValue("password", user.getPassword())
            .addValue("user_name", user.getUserName())
            .addValue("birthday", user.getBirthday())
            .addValue("age", user.getAge())
            .addValue("marrige", user.isMarrige())
            .addValue("user_id", user.getUserId());

        return jdbc.update(sql, params);
    }

    @Override
    public int deleteOne(String userId) {
        String sql = "delete from m_user where user_id = :userId";

        //パラメーター
        SqlParameterSource params = new MapSqlParameterSource().addValue("user_id", userId);

        //SQL実行
        int rowNumber = jdbc.update(sql, params);
        return rowNumber;
    }

    public void userCsvOut() {
        String sql = "select * from m_user";

        UserRowCallbackHandler handler = new UserRowCallbackHandler();

        jdbc.query(sql, handler);
    }
}