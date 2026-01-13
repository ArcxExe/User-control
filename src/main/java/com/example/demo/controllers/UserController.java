package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.User;
import com.example.demo.servise.UserServise;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

  private final UserServise userServise;

  UserController(UserServise userServise) {
    this.userServise = userServise;
  }

  @GetMapping
  public List<User> index() {
    return userServise.GetAllUser();
  }

  @PostMapping
  public User create(@RequestBody User user) {
    return userServise.create(user);
  }

  @DeleteMapping(path = "{id}")
  public void delete(@PathVariable(name = "id") Long id) { // Request = localhost:8080/api/users/{id} - вместо id число
                                                           // - api/users/1
    userServise.delete(id);
  }

  @PutMapping("{id}")
  public User update(
      @PathVariable Long id,
      @RequestParam(required = false) String email,
      @RequestParam(required = false) String name) {
    
   return userServise.update(id , email, name);

  }

}
