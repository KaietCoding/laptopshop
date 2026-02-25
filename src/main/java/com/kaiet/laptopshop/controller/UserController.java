package com.kaiet.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaiet.laptopshop.service.UserService;

// @Controller
@Controller
public class UserController {
  UserService service;
  
  public UserController(UserService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public String getHomePage(){
    String test = service.handleHello();
    return "kaiet.html";
  }
}
