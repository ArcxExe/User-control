package com.example.demo.servise;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServise {

  private final UserRepository userRepository;

  UserServise(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> GetAllUser() {
    return userRepository.findAll();
  }



}
