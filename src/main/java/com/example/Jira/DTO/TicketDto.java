package com.example.Jira.DTO;

import com.example.Jira.Enum.Priority;
import com.example.Jira.Enum.TicketStatus;
import com.example.Jira.Enum.TicketType;

import lombok.Data;

@Data
public class TicketDto {
	private String title;
	private String description;

	private TicketType type;
	private Priority priority;
	private TicketStatus status;

	private Long boardId;
	private Long assigneeId;

	private Long version;

}
