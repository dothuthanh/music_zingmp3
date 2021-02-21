package com.bolero.boleroteam.service.impl;

import com.bolero.boleroteam.model.User;
import com.bolero.boleroteam.repository.UserRepository;
import com.bolero.boleroteam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void changePassword(User user, String oldPassword, String newPassword) {
        if (!encoder.matches(oldPassword,user.getPassword())){
            throw new NullPointerException();
        }
        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);
    }

}
