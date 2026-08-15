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

import com.example.Jira.DTO.BoardDto;
import com.example.Jira.Entity.Board;
import com.example.Jira.Service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService service;

	@PostMapping
	public ResponseEntity<Board> save(@RequestBody BoardDto dto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<Board>> getAll() {

		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Board> getOne(@PathVariable Long id) {

		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/project/{projectId}")
	public ResponseEntity<List<Board>> getByProject(@PathVariable Long projectId) {

		return ResponseEntity.ok(service.getByProject(projectId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody BoardDto dto) {

		return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		return ResponseEntity.ok(service.delete(id));
	}
}
