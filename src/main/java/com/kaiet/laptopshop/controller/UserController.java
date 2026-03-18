package com.kaiet.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.kaiet.laptopshop.domain.User;
import com.kaiet.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {
  private final UserService userService;
  

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public String getHomePage(Model model){
    List<User> listUsers = this.userService.getUsersByEmail("kai01237@gmail.com");
    System.out.println(listUsers);
    return "hello";
  }

  @GetMapping("admin/user")
  public String getUserPage(Model model){
    List<User> users = this.userService.getAllUsers();
    model.addAttribute("users", users);
    return "admin/user/table-user";
  }

  //USER DETAIL PAGE
  @GetMapping("admin/user/{id}")
  public String getUserDetailPage(@PathVariable long id,Model model){
    User user = this.userService.getUserById(id);
    model.addAttribute("user",user);
    return"admin/user/show";
  }

  // get method for update user page
  @GetMapping("admin/user/update/{id}")
  public String getUpdateUserPage(@PathVariable long id, Model model){
    User user = this.userService.getUserById(id);
    model.addAttribute("newUser", user);
    return "admin/user/update";
  }

  // get method for create page
  @GetMapping("admin/user/create")
  public String getCreatUserPage(Model model){
    model.addAttribute("newUser", new User());
    return "admin/user/create";
  }

  // get method for delete page
  @GetMapping("admin/user/delete/{id}")
  public String getDeleteUserPage(@PathVariable long id,Model model){
    User user = this.userService.getUserById(id);
    model.addAttribute("newUser", user);
    return "admin/user/delete";
  }

  // create user post method
  @PostMapping("admin/user/create")
  public String creatUserPage(Model model,@ModelAttribute("newUser") User kaiet){
    this.userService.saveUser(kaiet);
    return "redirect:/admin/user";
  }
  // update user post method
  @PostMapping("admin/user/update")
  public String postUpdateUser(@ModelAttribute("newUser") User updatedUser){
    User user = this.userService.getUserById(updatedUser.getId());
    System.out.println(updatedUser.getId());
    System.out.println(user);
    if(user != null){
      user.setAddress(updatedUser.getAddress());
      user.setFullname(updatedUser.getFullname());
      user.setPhone(updatedUser.getPhone());
      user.setAddress(updatedUser.getAddress());
      System.out.println("run here");
      this.userService.saveUser(user);
    }
    return "redirect:/admin/user";
  }

  //delete user post method
  @PostMapping("admin/user/delete")
  public String postDeleteUser(@ModelAttribute("newUser") User user){
    System.out.println(user);
    this.userService.deleteUserbyId(user.getId());
    return "redirect:/admin/user";
  }
}
