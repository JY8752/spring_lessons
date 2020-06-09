package com.example.spring_lessons;

import static org.junit.Assert.*;

import com.example.spring_lessons.repository.jdbc.UserDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserDaoTest {

    @Autowired
    @Qualifier("UserDaoJdbcImpl")
    UserDao dao;

    @Test
    public void カウントメソッドの結果が２件() {
        assertEquals(dao.count(), 2);
    }
    
}