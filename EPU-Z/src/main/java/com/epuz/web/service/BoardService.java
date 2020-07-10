package com.epuz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epuz.web.domain.PageSet;
import com.epuz.web.dto.FreeBoardListDTO;
import com.epuz.web.dto.FreeBoardModifyDTO;
import com.epuz.web.dto.FreeBoardPostDTO;
import com.epuz.web.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	public BoardMapper boardMapper;
	
	public List<FreeBoardListDTO> freeBoardListTemp(){
		return boardMapper.freeBoardListTemp();
	}
	
	public int freeBoardListCount(PageSet pageSet) {
		return boardMapper.countPaging(pageSet);
	}
	
	public List<FreeBoardListDTO> freeBoardList(PageSet pageSet){
		return boardMapper.freeBoardList(pageSet);
	}
	
	public FreeBoardPostDTO freeBoardPost(int postNumber) {
		return boardMapper.freeBoardPost(postNumber);
	}
	
	public void FreeBoardRegistration(String title, long writer, String content) {
		boardMapper.freeBoardRegistration(title, writer, content);
	}
	
	public FreeBoardModifyDTO FreeBoardModifyPage(long postNumber) {
		return boardMapper.freeBoardModifyPage(postNumber);
	}
	
	public void FreeBoardModify(long postNumber, String title, String content) {
		boardMapper.freeBoardModify(postNumber, title, content);
	}
	
	public void FreeBoardDelete(long postNumber) {
		boardMapper.freeBoardDelete(postNumber);
	}
	

}
