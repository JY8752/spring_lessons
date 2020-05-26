package com.example.spring_lessons.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.spring_lessons.GroupOrder;
import com.example.spring_lessons.SignUpForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
  
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

    return "redirect:/login";
  }
}