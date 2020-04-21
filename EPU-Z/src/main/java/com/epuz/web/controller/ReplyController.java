package com.epuz.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.epuz.web.dto.FreeBoardReplyDTO;
import com.epuz.web.service.ReplyService;

@RestController
public class ReplyController {
	
	@Autowired
	ReplyService replyService;

	@GetMapping("replyList")
	public ResponseEntity<ArrayList<FreeBoardReplyDTO>> freeBoardReplyList(@PathVariable("postNumber") long postNumber){
		ResponseEntity<ArrayList<FreeBoardReplyDTO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(replyService.freeBoardReplyList(postNumber), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
