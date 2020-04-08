package com.epuz.web.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FreeBoardPostDTO {
	
	private long postNumber;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime writeDate;
	private int viewCount;
	private int replyCount;

}
