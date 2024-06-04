package com.example.LawConsultation.service;

import com.example.LawConsultation.entity.User;
import com.example.LawConsultation.enums.UserType;
import com.example.LawConsultation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User newUser) {
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists!");
        }
        newUser.setType(UserType.CLIENT);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public User loginUser(String email, String password, UserType type) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User user = optionalUser.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("wrong password!");
        }
        else if(user.getType() != type) {
            throw new RuntimeException("wrong type");
        }
        return user;
    }

    public User getById(long userId){
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        if( optionalUser.isEmpty()){
            throw new RuntimeException("user not found!");
        }
        return optionalUser.get();
    }
}
