package com.Creepercao.Blog.dao;

import com.Creepercao.Blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByEmailIgnoreCase(String email);

    User findByNameAndPassword(String name, String password);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByEmailIgnoreCase(String email);
}