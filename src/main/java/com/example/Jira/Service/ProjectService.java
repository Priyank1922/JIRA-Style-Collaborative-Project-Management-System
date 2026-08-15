package com.example.Jira.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Jira.DTO.ProjectDto;
import com.example.Jira.Entity.Project;
import com.example.Jira.Repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectRepository repo;

	public Project create(ProjectDto dto) {

		Project project = new Project();

		project.setName(dto.getName());
		project.setDescription(dto.getDescription());
		project.setCreatedBy(dto.getCreatedBy());
		project.setUpdatedBy(dto.getUpdatedBy());

		return repo.save(project);
	}

	public List<Project> getAll() {

		return repo.findAll();
	}

	public Project getOne(Long id) {

		return repo.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found With id: " + id));
	}

	public Project update(Long id, ProjectDto dto) {

		Project project = repo.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found With id: " + id));

		project.setName(dto.getName());
		project.setDescription(dto.getDescription());
		project.setUpdatedBy(dto.getUpdatedBy());

		return repo.save(project);
	}

	public String delete(Long id) {

		Project project = repo.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found With id: " + id));

		repo.delete(project);

		return "Project Deleted Successfully";
	}
}