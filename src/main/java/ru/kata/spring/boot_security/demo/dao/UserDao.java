package ru.kata.spring.boot_security.demo.dao;




import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Component
public interface UserDao {
    List<User> showUsers();

    public void addUser(User user);

    public User findUserById(int id);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
