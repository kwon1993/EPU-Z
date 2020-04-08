package com.epuz.web.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FreeBoardListDTO {
	
	private long postNumber;
	private String title;
	private String writer;
	private LocalDateTime writeDate;
	private int viewCount;
	private int replyCount;

}
