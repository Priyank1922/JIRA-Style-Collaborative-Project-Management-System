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

import com.example.Jira.DTO.CommentDto;
import com.example.Jira.Entity.Comment;
import com.example.Jira.Service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

	private final CommentService service;

	@PostMapping
	public ResponseEntity<Comment> save(@RequestBody CommentDto dto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<Comment>> getAll() {

		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comment> getOne(@PathVariable Long id) {

		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<List<Comment>> getByTicket(@PathVariable Long ticketId) {

		return ResponseEntity.ok(service.getByTicket(ticketId));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Comment>> getByUser(@PathVariable Long userId) {

		return ResponseEntity.ok(service.getByUser(userId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Comment> update(@PathVariable Long id, @RequestBody CommentDto dto) {

		return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		return ResponseEntity.ok(service.delete(id));
	}
}
