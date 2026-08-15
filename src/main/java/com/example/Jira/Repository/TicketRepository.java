package com.example.Jira.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jira.Entity.Ticket;
import com.example.Jira.Enum.Priority;
import com.example.Jira.Enum.TicketStatus;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByBoardId(Long boardId);

	List<Ticket> findByAssigneeId(Long userId);

	List<Ticket> findByStatus(TicketStatus status);

	List<Ticket> findByPriority(Priority priority);

}
