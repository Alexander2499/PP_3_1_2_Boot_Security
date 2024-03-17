package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<User> showUsers();

    void save(User user);

    User findUserById(long id);

    void update(User updatedUser);

    void delete(long id);
}
