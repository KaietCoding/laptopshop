package com.kaiet.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kaiet.laptopshop.domain.User;
import com.kaiet.laptopshop.service.UserService;

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
    List<User> users = this.userService.getAllUsers();
    model.addAttribute("users", users);
    return "admin/user/table-user";
  }

  //USER DETAIL PAGE
  @RequestMapping("admin/user/{id}")
  public String getUserDetailPage(@PathVariable long id,Model model){
    User user = this.userService.getUserById(id);
    model.addAttribute("user",user);
    return"admin/user/show";
  }

  @RequestMapping("admin/user/update/{id}")
  public String getUpdateUserPage(@PathVariable long id, Model model){
    User user = this.userService.getUserById(id);
    model.addAttribute("newUser", user);
    return "admin/user/update";
  }

  @RequestMapping("admin/user/create")
  public String getCreatUserPage(Model model){
    model.addAttribute("newUser", new User());
    return "admin/user/create";
  }

  @RequestMapping(value="admin/user/create",method = RequestMethod.POST)
  public String creatUserPage(Model model,@ModelAttribute("newUser") User kaiet){
    this.userService.saveUser(kaiet);
    return "redirect:/admin/user";
  }

  @PostMapping("admin/user/update/{id}")
  public String postUpdateUser(@PathVariable long id,@ModelAttribute("newUser") User updatedUser){
    User user = this.userService.getUserById(id);
    if(user != null){
      user.setAddress(updatedUser.getAddress());
      user.setFullname(updatedUser.getFullname());
      user.setPhone(updatedUser.getPhone());
      System.out.println("run here");
      this.userService.saveUser(user);
    }
    return "redirect:/admin/user";
  }
}
