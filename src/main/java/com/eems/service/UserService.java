package com.eems.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eems.model.User;
import com.eems.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

	public Object getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<String> deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}