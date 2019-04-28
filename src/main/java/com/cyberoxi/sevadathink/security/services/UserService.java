//package com.cyberoxi.sevadathink.security.services;
//
//import com.cyberoxi.sevadathink.model.User;
//import com.cyberoxi.sevadathink.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
//        this.userRepository = repo;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public void save(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//
//}