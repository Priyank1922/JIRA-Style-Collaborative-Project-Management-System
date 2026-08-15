package com.example.Jira.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Jira.DTO.UserDto;
import com.example.Jira.Entity.User;
import com.example.Jira.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repo;

	public User create(UserDto dto) {
		User us = new User();
		us.setName(dto.getName());
		us.setEmail(dto.getName());
		return repo.save(us);
	}

	public List<User> getAll() {
		return repo.findAll();
	}

	public User getOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("User Not found With id No:" + id));
	}

	public User Update(Long id, UserDto dto) {
		User us = repo.findById(id).orElseThrow(() -> new RuntimeException("User Not found With id No:" + id));
		us.setName(dto.getName());
		us.setEmail(dto.getEmail());
		return repo.save(us);

	}

	public String delete(Long id) {
		repo.deleteById(id);
		return "User Deleted Successfully";
	}

	public User findByName(String name) {
		return repo.findByName(name).orElseThrow(() -> new RuntimeException("User Not found With this name:" + name));
	}

}
