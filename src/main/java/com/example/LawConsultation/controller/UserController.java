package com.example.LawConsultation.controller;

import com.example.LawConsultation.entity.User;
import com.example.LawConsultation.enums.UserType;
import com.example.LawConsultation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public User addUser(@RequestBody User newUser){
        return this.userService.registerUser(newUser);
    }

    @PostMapping("/login_client")
    @ResponseBody
    public User loginAsClient(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password, UserType.CLIENT);
    }

    @PostMapping("/login_lawyer")
    @ResponseBody
    public User loginAsLawyer(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password, UserType.LAWYER);
    }

    @GetMapping("/getById/{userId}")
    @ResponseBody
    public User getById(@PathVariable Long userId){
        return userService.getById(userId);
    }

}
