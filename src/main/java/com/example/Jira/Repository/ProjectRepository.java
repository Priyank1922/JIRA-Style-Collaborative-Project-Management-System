package com.example.Jira.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jira.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
