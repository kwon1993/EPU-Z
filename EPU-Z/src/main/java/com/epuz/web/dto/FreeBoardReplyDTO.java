package com.epuz.web.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FreeBoardReplyDTO {
	
	private long ReplyNumber;
	private long PostNumber;
	private String writer;
	private String content;
	private LocalDateTime writeDate;

}
