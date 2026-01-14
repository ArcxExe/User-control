package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User , Long> {

  @Query(value = "select * from users where email = :email") // @Query(value= ... , nativeQuery = true) - это одно и тоже   
  Optional<User> findByEmail(String email);
  User getById(Long id);
  @Query(value = "select * from users where name= :name") // @Query(value= ... , nativeQuery = true) - это одно и тоже   
  Optional<User> findByName(String name);
}
