package com.codecool.shitwish.service;

import com.codecool.shitwish.model.User;
import com.codecool.shitwish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void add(User user) {
        userRepository.save(user);
    }

    public User find(Long id) {
        return userRepository.findOne(id);
    }

    public void update(Long id, String password) {
        User user = find(id);
        user.setPassword(password);
        userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.delete(id);
    }

    public List<User> all() {
        return userRepository.findAll();
    }

    public void saveUser(String password, String email) {
        User user = new User(email,password);
        userRepository.save(user);
    }

    public User loginUser(Long userId, String password) {
        User user = userRepository.findOne(userId);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean validateUser(String email, String password) {
        List<User> users = userRepository.findAll();
        boolean validation = false;
        for (User user : users) {
            if (user.getEmail() != email) validation = true;
        }
        return validation;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }


}
