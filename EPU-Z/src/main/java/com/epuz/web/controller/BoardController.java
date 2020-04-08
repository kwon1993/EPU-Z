package com.epuz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epuz.web.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	public BoardService boardService;
	
	@GetMapping("/freeBoardList")
	public String freeBoardList(Model model) {
		model.addAttribute("freeBoardList", boardService.freeBoardList());
		return "board/freeBoardList";
	}
	
	@GetMapping("freeBoardPost")
	public String freeBoardPost(@RequestParam("postNumber") int postNumber, Model model) {
		model.addAttribute("freeBoardPost", boardService.freeBoardPost(postNumber));
		return "board/freeBoardPost";
	}

}
