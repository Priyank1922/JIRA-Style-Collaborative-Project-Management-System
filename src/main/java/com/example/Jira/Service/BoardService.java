package com.example.Jira.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Jira.DTO.BoardDto;
import com.example.Jira.Entity.Board;
import com.example.Jira.Entity.Project;
import com.example.Jira.Repository.BoardRepository;
import com.example.Jira.Repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepo;
	private final ProjectRepository projectRepo;

	public Board create(BoardDto dto) {

		Project project = projectRepo.findById(dto.getProjectId())
				.orElseThrow(() -> new RuntimeException("Project Not Found With id: " + dto.getProjectId()));

		Board board = new Board();

		board.setName(dto.getName());
		board.setDescription(dto.getDescription());
		board.setProject(project);

		return boardRepo.save(board);
	}

	public List<Board> getAll() {

		return boardRepo.findAll();
	}

	public Board getOne(Long id) {

		return boardRepo.findById(id).orElseThrow(() -> new RuntimeException("Board Not Found With id: " + id));
	}

	public Board update(Long id, BoardDto dto) {

		Board board = boardRepo.findById(id).orElseThrow(() -> new RuntimeException("Board Not Found With id: " + id));

		Project project = projectRepo.findById(dto.getProjectId())
				.orElseThrow(() -> new RuntimeException("Project Not Found With id: " + dto.getProjectId()));

		board.setName(dto.getName());
		board.setDescription(dto.getDescription());
		board.setProject(project);

		return boardRepo.save(board);
	}

	public List<Board> getByProject(Long projectId) {

		return boardRepo.findByProjectId(projectId);
	}

	public String delete(Long id) {

		Board board = boardRepo.findById(id).orElseThrow(() -> new RuntimeException("Board Not Found With id: " + id));

		boardRepo.delete(board);

		return "Board Deleted Successfully";
	}
}