package com.example.Jira.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Jira.DTO.TicketDto;
import com.example.Jira.Entity.Board;
import com.example.Jira.Entity.Ticket;
import com.example.Jira.Entity.User;
import com.example.Jira.Enum.Priority;
import com.example.Jira.Enum.TicketStatus;
import com.example.Jira.Repository.BoardRepository;
import com.example.Jira.Repository.TicketRepository;
import com.example.Jira.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

	private final TicketRepository ticketRepo;
	private final BoardRepository boardRepo;
	private final UserRepository userRepo;

	public Ticket create(TicketDto dto) {

		Board board = boardRepo.findById(dto.getBoardId())
				.orElseThrow(() -> new RuntimeException("Board Not Found With id: " + dto.getBoardId()));

		User user = userRepo.findById(dto.getAssigneeId())
				.orElseThrow(() -> new RuntimeException("User Not Found With id: " + dto.getAssigneeId()));

		Ticket ticket = new Ticket();

		ticket.setTitle(dto.getTitle());
		ticket.setDescription(dto.getDescription());
		ticket.setType(dto.getType());
		ticket.setPriority(dto.getPriority());
		ticket.setStatus(dto.getStatus());

		ticket.setBoard(board);
		ticket.setAssignee(user);

		return ticketRepo.save(ticket);
	}

	public List<Ticket> getAll() {

		return ticketRepo.findAll();
	}

	public Ticket getOne(Long id) {

		return ticketRepo.findById(id).orElseThrow(() -> new RuntimeException("Ticket Not Found With id: " + id));
	}

	public Ticket update(Long id, TicketDto dto) {

		Ticket ticket = ticketRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Ticket Not Found With id: " + id));

		Board board = boardRepo.findById(dto.getBoardId())
				.orElseThrow(() -> new RuntimeException("Board Not Found With id: " + dto.getBoardId()));

		User user = userRepo.findById(dto.getAssigneeId())
				.orElseThrow(() -> new RuntimeException("User Not Found With id: " + dto.getAssigneeId()));

		ticket.setTitle(dto.getTitle());
		ticket.setDescription(dto.getDescription());
		ticket.setType(dto.getType());
		ticket.setPriority(dto.getPriority());
		ticket.setStatus(dto.getStatus());

		ticket.setBoard(board);
		ticket.setAssignee(user);

		return ticketRepo.save(ticket);
	}

	public List<Ticket> getByBoard(Long boardId) {

		return ticketRepo.findByBoardId(boardId);
	}

	public List<Ticket> getByAssignee(Long userId) {

		return ticketRepo.findByAssigneeId(userId);
	}

	public List<Ticket> getByStatus(TicketStatus status) {

		return ticketRepo.findByStatus(status);
	}

	public List<Ticket> getByPriority(Priority priority) {

		return ticketRepo.findByPriority(priority);
	}

	public String delete(Long id) {

		Ticket ticket = ticketRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Ticket Not Found With id: " + id));

		ticketRepo.delete(ticket);

		return "Ticket Deleted Successfully";
	}
}
