package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String showAllUsers(Model model){
        List<User> users = userService.listAll();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","add user");
        return "add";
    }
    @PostMapping("/save")
    public String postUser(User user, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message_success","user has been added successufely");
        userService.saveUser(user);
       return "redirect:/users";
    }
    @GetMapping("users/edit/{id}")
        public String editUser(@PathVariable("id") int id, Model model){
            User user = userService.getUser(id);
            model.addAttribute("user",user);
            model.addAttribute("title","edit user");
            return "add";
        }
 @GetMapping("users/delete/{id}")
 public String deleteUser(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message_danger","user has been deleted successufely");
        userService.deleteUser(id);
        return "redirect:/users";
 }

}
