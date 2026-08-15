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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jira.DTO.TicketDto;
import com.example.Jira.Entity.Ticket;
import com.example.Jira.Enum.Priority;
import com.example.Jira.Enum.TicketStatus;
import com.example.Jira.Service.TicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {

	private final TicketService service;

	@PostMapping
	public ResponseEntity<Ticket> save(@RequestBody TicketDto dto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<Ticket>> getAll() {

		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getOne(@PathVariable Long id) {

		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/board/{boardId}")
	public ResponseEntity<List<Ticket>> getByBoard(@PathVariable Long boardId) {

		return ResponseEntity.ok(service.getByBoard(boardId));
	}

	@GetMapping("/assignee/{userId}")
	public ResponseEntity<List<Ticket>> getByAssignee(@PathVariable Long userId) {

		return ResponseEntity.ok(service.getByAssignee(userId));
	}

	@GetMapping("/status")
	public ResponseEntity<List<Ticket>> getByStatus(@RequestParam TicketStatus status) {

		return ResponseEntity.ok(service.getByStatus(status));
	}

	@GetMapping("/priority")
	public ResponseEntity<List<Ticket>> getByPriority(@RequestParam Priority priority) {

		return ResponseEntity.ok(service.getByPriority(priority));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ticket> update(@PathVariable Long id, @RequestBody TicketDto dto) {

		return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		return ResponseEntity.ok(service.delete(id));
	}
}
