package com.sk.userservice.services;

import com.sk.userservice.entities.User;
import com.sk.userservice.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            log.info("Username: "+user.get().getUsername());
            log.info("Email: "+user.get().getEmail());
        }
        return user;
    }

    public User registerUser(@Valid User user) {
        return userRepository.save(user);
    }
}
