package com.example.spring_lessons.Controller;

import com.example.spring_lessons.Employee;
import com.example.spring_lessons.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

  @Autowired
  HelloService helloService;

  @GetMapping("/hello")
  public String getHello(){
    return "hello";
  }

  @PostMapping("/hello")
  public String postRequest(@RequestParam("text1") String str, Model model){
    model.addAttribute("sample", str);
    return "helloResponse";
  }

  @PostMapping("/hello/db")
  public String postDbRequest(@RequestParam("text2")String str, Model model){

    int id = Integer.parseInt(str);

    Employee employee = helloService.findByOne(id);

    model.addAttribute("id", employee.getEmployeeId());
    model.addAttribute("name", employee.getEmployeeName());
    model.addAttribute("age", employee.getAge());

    return "helloResponseDB";

  }


}