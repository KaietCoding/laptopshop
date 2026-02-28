package com.kaiet.laptopshop.service;

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
}
