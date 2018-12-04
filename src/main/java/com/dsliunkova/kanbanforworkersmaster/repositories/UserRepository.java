package com.dsliunkova.kanbanforworkersmaster.repositories;

import com.dsliunkova.kanbanforworkersmaster.entities.User;
import com.dsliunkova.kanbanforworkersmaster.entities.enums.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByLoginAndPassword(String login, String password);

    public List<User> findAllByRole(Role role);
}
