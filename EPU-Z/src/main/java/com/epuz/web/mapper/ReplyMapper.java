package com.epuz.web.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.epuz.web.dto.FreeBoardReplyDTO;

@Mapper
public interface ReplyMapper {
	
	public ArrayList<FreeBoardReplyDTO> freeBoardReplyList(long postNumber);

}
