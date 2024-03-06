package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<User> showUsers();

    public void save(User user);

    public User findUserById(int id);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
