package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.User;
import com.example.demo.servise.UserServise;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path = "api/users")
public class UserController {

  private final UserServise userServise;

  UserController(UserServise userServise){
    this.userServise = userServise;
  }


  @GetMapping
  public List<User> index() {
    return userServise.GetAllUser();
  }

}
