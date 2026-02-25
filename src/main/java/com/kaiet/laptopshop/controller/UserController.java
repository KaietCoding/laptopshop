package com.kaiet.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String getHomePage(Model model){
    String test = service.handleHello();
    model.addAttribute("kaiet",test);
    model.addAttribute("hello","Hello from controller");
    return "hello";
  }
}
