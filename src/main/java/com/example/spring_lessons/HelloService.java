package com.example.spring_lessons;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  @Autowired
  HelloRepositry helloRepositry;

  public Employee findByOne(int id){

    Map<String, Object>map = helloRepositry.findOne(id);

    Employee employee = new Employee();
    
    employee.setEmployeeId((int)map.get("employee_id"));
    employee.setEmployeeName((String)map.get("employee_name"));
    employee.setAge((int)map.get("age"));

    return employee;
    
  }
  
}