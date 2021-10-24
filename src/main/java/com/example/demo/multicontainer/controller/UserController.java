package com.example.demo.multicontainer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.multicontainer.entity.User;
import com.example.demo.multicontainer.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@PutMapping("/users/{user_id}")
	public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject) {
		Optional<User> user = userRepository.findById(userId);
		User u = user.get();
		u.setName(userObject.getName());
		u.setCountry(userObject.getCountry());
		return userRepository.save(u);
	}

	@DeleteMapping("/users/{user_id}")
	public List<User> delete(@PathVariable("user_id") Long userId) {
		userRepository.deleteById(userId);
		return userRepository.findAll();
	}

	@GetMapping("/users/{user_id}")
	@ResponseBody
	public Optional<User> findByUserId(@PathVariable("user_id") Long userId) {
		return userRepository.findById(userId);
	}
}
