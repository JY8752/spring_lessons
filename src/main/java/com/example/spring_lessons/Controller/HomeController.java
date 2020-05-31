package com.example.spring_lessons.Controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.spring_lessons.entity.User;
import com.example.spring_lessons.form.SignUpForm;
import com.example.spring_lessons.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    private Map<String, String> radioMarrige;

    private Map<String, String> initRadioMarrige(){
        Map<String, String> radio = new LinkedHashMap<>();
        radio.put("既婚", "true");
        radio.put("未婚", "false");

        return radio;
    }

    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("contents", "home :: home_contents");
        return "homeLayout";
    }

    @GetMapping("/userList")
    public String getUserList(Model model){

        model.addAttribute("contents", "userList :: userList_contents");

        List<User> userList = userService.selectMany();
        model.addAttribute("userList", userList);

        int count = userService.count();
        model.addAttribute("userListCount", count);

        return "homeLayout";
    }

    @GetMapping("/userDetail/{id:.+}")
    public String getUserDetail(@ModelAttribute SignUpForm signupForm, Model model, @PathVariable("id") String userId){

        System.out.println("userId = " + userId);

        model.addAttribute("contents", "userDetail :: userDetail_contents");

        radioMarrige = initRadioMarrige();
        model.addAttribute("radioMarrige", radioMarrige);

        if(userId != null && userId.length() > 0) {
            User user = userService.selectOne(userId);

            signupForm.setUserId(user.getUserId());
            signupForm.setUserName(user.getUserName());
            signupForm.setBirthday(user.getBirthday());
            signupForm.setAge(user.getAge());
            signupForm.setMarrige(user.isMarrige());

            model.addAttribute("signupForm", signupForm);
        }
        return "homeLayout";
    }

    @PostMapping(value="/userDetail", params = "update")
    public String postUserDetailUpdate(@ModelAttribute SignUpForm signupForm, Model model){

        System.out.println("更新ボタンの処理");

        User user = new User();
        user.setUserId(signupForm.getUserId());
        user.setPassword(signupForm.getPassword());
        user.setUserName(signupForm.getUserName());
        user.setBirthday(signupForm.getBirthday());
        user.setAge(signupForm.getAge());
        user.setMarrige(signupForm.isMarrige());

        boolean result = userService.updateOne(user);

        if(result == true){
            model.addAttribute("result", "更新成功");
        } else{
            model.addAttribute("result", "更新失敗");
        }
        return getUserList(model);
    }

    @PostMapping(value="/userDetail", params = "delete")
    public String postUserDetailDelete(@ModelAttribute SignUpForm signupForm, Model model){

        System.out.println("削除ボタンの処理");

        boolean result = userService.deleteOne(signupForm.getUserId());

        if(result == true){
            model.addAttribute("result", "削除成功");
        } else {
            model.addAttribute("result", "削除失敗");
        }
        return getUserList(model);
    }

    @PostMapping("/logout")
    public String postLogout(){
        return "redirect:/login";
    }

    @GetMapping("/userList/csv")
    public ResponseEntity<byte[]> getUserListCsv(Model model){
        userService.userCsvOut();

        byte[] bytes = null;

        try{
            bytes = userService.getFile("sample.csv");
        } catch(IOException e) {
            e.printStackTrace();
        }

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=UTF-8");
        header.setContentDispositionFormData("filename", "sample.csv");

        return new ResponseEntity<>(bytes, header, HttpStatus.OK);
    }
    
}