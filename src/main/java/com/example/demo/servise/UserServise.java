package com.example.demo.servise;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

  public User create(User entity) {
    Optional<User> optionalUser = userRepository.findByEmail(entity.getEmail());

    if (optionalUser.isPresent()) {
      throw new IllegalStateException("User with this email is used");
    }
    entity.setAge(Period.between(entity.getBirth(), LocalDate.now()).getYears());
    return userRepository.save(entity);
  }

  public void delete(Long id) {
    Optional<User> optionaluser = userRepository.findById(id);

    if (optionaluser.isEmpty()) {
      throw new IllegalArgumentException("Users with "+id+" не существует");
    }
    userRepository.deleteById(id);
  }

  public User update(Long id , String email , String name) {
    Optional<User> optionaluser = userRepository.findById(id);

    if (optionaluser.isEmpty()) {
      throw new IllegalArgumentException("Users with "+id+" не существует");
    }

    User user = userRepository.getById(id);

    if (email != null && !email.equals(user.getEmail())) {
      Optional<User> foundedEmail= userRepository.findByEmail(email);

      if (foundedEmail.isPresent()) {
         throw new IllegalStateException("User with this email is used");   
      }

      user.setEmail(email);
    }

    if (name!= null && !name.equals(user.getName())) {
      Optional<User> foundedName= userRepository.findByName(name);

      if (foundedName.isPresent()) {
         throw new IllegalStateException("User with this email is used");   
      }

      user.setName(name);
      userRepository.save(user);
    }
    
    return user;

  }

}
