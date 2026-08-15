package com.example.Jira.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jira.Entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByProjectId(Long projectId);

}
