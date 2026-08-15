package com.example.Jira.DTO;

import lombok.Data;

@Data
public class CommentDto {

	private String content;
	private Long ticketId;
	private Long userId;
}
