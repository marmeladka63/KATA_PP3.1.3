package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User findUserById(Long id);

    void saveUser(User user);

    void delete(Long id);

    void update(Long id, User user);

    public User getUserByUsername(String username);

}
