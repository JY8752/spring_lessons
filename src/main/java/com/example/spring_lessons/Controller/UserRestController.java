package com.example.spring_lessons.Controller;

import java.util.List;

import com.example.spring_lessons.entity.User;
import com.example.spring_lessons.service.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    
    @Autowired
    RestService restService;

    //ユーザー全件取得
    @GetMapping("/rest/get")
    public List<User> getUserMany(){
        return restService.selectMany();
    }
    //ユーザー１件取得
    @GetMapping("/rest/get/{id:.+}")
    public User getUserOne(@PathVariable("id") String userId) {
        return restService.selectOne(userId);
    }
    @PostMapping("rest/insert")
    public String postUserOne(@RequestBody User user) {
        boolean result = restService.insert(user);

        String str = "";
        if(result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }
    @PutMapping("/rest/update")
    public String putUserOne(@RequestBody User user) {
        boolean result = restService.update(user);
        String str = "";
        if(result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }
    @DeleteMapping("/rest/delete/{id:.+}")
    public String deleteUserOne(@PathVariable("id") String userId) {
        boolean result = restService.delete(userId);
        String str = "";
        if(result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }
}