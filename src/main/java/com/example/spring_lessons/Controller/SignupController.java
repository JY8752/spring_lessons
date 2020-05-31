package com.example.spring_lessons.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.spring_lessons.Validation.GroupOrder;
import com.example.spring_lessons.entity.User;
import com.example.spring_lessons.form.SignUpForm;
import com.example.spring_lessons.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    UserService userService;

  
  private Map<String, String>radioMarrige;

  private Map<String, String> initRadioMarrige(){

    Map<String, String> radio = new LinkedHashMap<>();

    radio.put("既婚", "true");
    radio.put("未婚", "false");

    return radio;
  }

  @GetMapping("/signup")
  public String getSignUp(@ModelAttribute SignUpForm signupForm, Model model){
    radioMarrige = initRadioMarrige();

    model.addAttribute("radioMarrige", radioMarrige);

    return "signup";
  }

  @PostMapping("/signup")
  public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignUpForm signupForm, 
  BindingResult bindingResult, Model model){

    if(bindingResult.hasErrors()){
      return getSignUp(signupForm, model);
    }

    System.out.println(signupForm);

    User user = new User();

    user.setUserId(signupForm.getUserId());
    user.setPassword(signupForm.getPassword());
    user.setUserName(signupForm.getUserName());
    user.setBirthday(signupForm.getBirthday());
    user.setAge(signupForm.getAge());
    user.setMarrige(signupForm.isMarrige());
    user.setRole("ROLE_GENERAL");

    boolean result = userService.insert(user);

    if(result == true){
        System.out.println("insert 成功");
    } else{
        System.out.println("insert 失敗");
    }
    return "redirect:/login";
  }
}