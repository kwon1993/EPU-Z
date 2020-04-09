package com.epuz.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epuz.web.dto.FreeBoardListDTO;
import com.epuz.web.dto.FreeBoardPostDTO;

@Mapper
public interface BoardMapper {
	
	public List<FreeBoardListDTO> freeBoardList();
	
	public FreeBoardPostDTO freeBoardPost(int postNumber);
	
	public void freeBoardRegistration(String title, long writer, String content);

}
