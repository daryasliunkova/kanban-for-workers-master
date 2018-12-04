package com.dsliunkova.kanbanforworkersmaster.services;

import com.dsliunkova.kanbanforworkersmaster.entities.User;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Role;
import com.dsliunkova.kanbanforworkersmaster.repositories.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(new Integer(id));
    }

    public void insertUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    public List<User> getAllCustomers() {
        return userRepository.findAllByRole(Role.CUSTOMER);
    }
}
