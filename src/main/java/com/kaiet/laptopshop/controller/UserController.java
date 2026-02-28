package com.kaiet.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaiet.laptopshop.domain.User;
import com.kaiet.laptopshop.repository.UserRepository;
import com.kaiet.laptopshop.service.UserService;

// @Controller
@Controller
public class UserController {
  private final UserService userService;
  

  public UserController(UserService userService) {
    this.userService = userService;
  }
  @RequestMapping("/")
  public String getHomePage(Model model){
    List<User> listUsers = this.userService.getUsersByEmail("kai01237@gmail.com");
    System.out.println(listUsers);
    return "hello";
  }
  @RequestMapping("admin/user")
  public String getUserPage(Model model){
    model.addAttribute("newUser", new User());
    return "admin/user/create";
  }

  @RequestMapping(value="admin/user/create",method = RequestMethod.POST)
  public String creatUserPage(Model model,@ModelAttribute("newUser") User kaiet){
    System.out.println(kaiet.toString());
    this.userService.saveUser(kaiet);
    return "hello";
  }
}
