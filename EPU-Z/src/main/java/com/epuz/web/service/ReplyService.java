package com.epuz.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epuz.web.dto.FreeBoardReplyDTO;
import com.epuz.web.mapper.ReplyMapper;

@Service
public class ReplyService {
	
	@Autowired
	ReplyMapper replyMapper;
	
	public ArrayList<FreeBoardReplyDTO> freeBoardReplyList(long postNumber) {
		return replyMapper.freeBoardReplyList(postNumber);
	}

}
