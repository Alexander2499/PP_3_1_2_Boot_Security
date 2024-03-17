package ru.kata.spring.boot_security.demo.controller;

import jakarta.transaction.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@Component
@RequestMapping("/")
@Transactional
public class UserController {

    private UserServiceImpl userService = new UserServiceImpl();

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/error")
    public String error () {
        return "error";
    }

    @GetMapping(value = "/users")
    public String showAllUsersOnWeb(Model model) {
        List<User> usersList = userService.showUsers();
        model.addAttribute("users", usersList);
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/refactor")
    public String refactorUsers(Model model,@PathVariable("id") long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "refactor";
    }

    @PostMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
