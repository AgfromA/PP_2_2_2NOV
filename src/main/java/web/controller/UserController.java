package web.controller;

import web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("users") User user) {
        return "new";
    }

    @PostMapping()//"/new"
    public String create(@ModelAttribute("users") User user) {
        userService.addUser(user);
        return "redirect:/people";

    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("users") @Valid User user,
                         BindingResult bindingResult, @RequestParam("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";
        userService.updateUser(id, user);
        return "redirect:/people";
    }

    @GetMapping("/removeUser")
    public String delete(@RequestParam("id") int id) {
        userService.removeUser(id);
        return "redirect:/people";
    }
}