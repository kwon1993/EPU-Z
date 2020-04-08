package com.epuz.web.domain;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class FreeBoardVO {
	
	private long postNumber;
	private String title;
	private long writer;
	private String content;
	private LocalDateTime writeDate;
	private int viewCount;
	private int replyCount;
	

}
