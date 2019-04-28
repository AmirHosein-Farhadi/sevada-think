//package com.cyberoxi.sevadathink.security.services;
//
//import com.cyberoxi.sevadathink.repositories.UserRepository;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Collectors;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public UserDetailsServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository
//                .findByUsername(username)
//                .map(u -> new User(
//                        u.getUsername(),
//                        u.getPassword(),
//                        u.isActive(),
//                        u.isActive(),
//                        u.isActive(),
//                        u.isActive(),
//                        AuthorityUtils.createAuthorityList(
//                                u.getRoles()
//                                        .stream()
//                                        .map(r -> "ROLE_" + r.getName().toUpperCase())
//                                        .collect(Collectors.toList())
//                                        .toArray(new String[]{}))))
//                .orElseThrow(() -> new UsernameNotFoundException("No user with "
//                        + "the name " + username + "was found in the database"));
//    }
//}

