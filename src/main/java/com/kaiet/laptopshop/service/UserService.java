package com.kaiet.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaiet.laptopshop.domain.User;
import com.kaiet.laptopshop.repository.UserRepository;

@Service
public class UserService {
  UserRepository userRepository;
  
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String handleHello(){
    return "Hello from service";
  }

  public User saveUser(User user){
    return this.userRepository.save(user);
  }

  public List<User> getAllUsers(){
    return this.userRepository.findAll();
  }

  public List<User> getUsersByEmail(String mail){
    return this.userRepository.findByEmail(mail);
  }
}
