package com.epuz.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epuz.web.dto.FreeBoardListDTO;
import com.epuz.web.dto.FreeBoardModifyDTO;
import com.epuz.web.dto.FreeBoardPostDTO;

@Mapper
public interface BoardMapper {
	
	public List<FreeBoardListDTO> freeBoardList();
	
	public FreeBoardPostDTO freeBoardPost(int postNumber);
	
	public void freeBoardRegistration(String title, long writer, String content);
	
	public FreeBoardModifyDTO freeBoardModifyPage(long postNumber);
	
	public void freeBoardModify(long postNumber, String title, String content);
	
	public void freeBoardDelete(long postNumber);

}
