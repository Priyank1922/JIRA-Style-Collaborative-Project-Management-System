package com.example.Jira.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Jira.DTO.CommentDto;
import com.example.Jira.Entity.Comment;
import com.example.Jira.Entity.Ticket;
import com.example.Jira.Entity.User;
import com.example.Jira.Repository.CommentRepository;
import com.example.Jira.Repository.TicketRepository;
import com.example.Jira.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepo;
	private final TicketRepository ticketRepo;
	private final UserRepository userRepo;

	public Comment create(CommentDto dto) {

		Ticket ticket = ticketRepo.findById(dto.getTicketId())
				.orElseThrow(() -> new RuntimeException("Ticket Not Found With id: " + dto.getTicketId()));

		User user = userRepo.findById(dto.getUserId())
				.orElseThrow(() -> new RuntimeException("User Not Found With id: " + dto.getUserId()));

		Comment comment = new Comment();

		comment.setContent(dto.getContent());
		comment.setTicket(ticket);
		comment.setUser(user);

		return commentRepo.save(comment);
	}

	public List<Comment> getAll() {

		return commentRepo.findAll();
	}

	public Comment getOne(Long id) {

		return commentRepo.findById(id).orElseThrow(() -> new RuntimeException("Comment Not Found With id: " + id));
	}

	public List<Comment> getByTicket(Long ticketId) {

		return commentRepo.findByTicketId(ticketId);
	}

	public List<Comment> getByUser(Long userId) {

		return commentRepo.findByUserId(userId);
	}

	public Comment update(Long id, CommentDto dto) {

		Comment comment = commentRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Comment Not Found With id: " + id));

		comment.setContent(dto.getContent());

		return commentRepo.save(comment);
	}

	public String delete(Long id) {

		Comment comment = commentRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Comment Not Found With id: " + id));

		commentRepo.delete(comment);

		return "Comment Deleted Successfully";
	}
}
