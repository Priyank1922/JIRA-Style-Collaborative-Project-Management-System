package com.example.Jira.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jira.DTO.UserDto;
import com.example.Jira.Entity.User;
import com.example.Jira.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

	private final UserService service;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody UserDto dto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<User>> getAll() {

		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getOne(@PathVariable Long id) {

		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<User> getByName(@PathVariable String name) {

		return ResponseEntity.ok(service.findByName(name));
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserDto dto) {

		return ResponseEntity.ok(service.Update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		return ResponseEntity.ok(service.delete(id));
	}
}
