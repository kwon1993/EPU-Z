package com.epuz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epuz.web.dto.FreeBoardModifyDTO;
import com.epuz.web.dto.FreeBoardRegistrationDTO;
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
	
	@GetMapping("/freeBoardPost")
	public String freeBoardPost(@RequestParam("postNumber") int postNumber, Model model) {
		model.addAttribute("freeBoardPost", boardService.freeBoardPost(postNumber));
		return "board/freeBoardPost";
	}
	
	@GetMapping("/freeBoardRegistration")
	public String freeBoardRegistration(Model model) {
		return "board/freeBoardRegistration";
	}
	
	@PostMapping("/freeBoardRegistration")
	public String freeBoardRegistration(FreeBoardRegistrationDTO freeBoardRegistrationDTO, Model model) {
		boardService.FreeBoardRegistration(freeBoardRegistrationDTO.getTitle(), freeBoardRegistrationDTO.getWriter(), freeBoardRegistrationDTO.getContent());
		return "redirect:freeBoardList";
	}
	
	@GetMapping("/freeBoardModify")
	public String freeBoardModify(@RequestParam("postNumber") int postNumber, Model model) {
		model.addAttribute("freeBoardModifyPage", boardService.FreeBoardModifyPage(postNumber));
		return "board/freeBoardModify";
	}
	
	@PostMapping("/freeBoardModify")
	public String freeBoardModify(FreeBoardModifyDTO freeBoardModifyDTO, Model model) {
		boardService.FreeBoardModify(freeBoardModifyDTO.getPostNumber(), freeBoardModifyDTO.getTitle(), freeBoardModifyDTO.getContent());
		return "redirect:freeBoardList";
	}
	
	@GetMapping("/freeBoardDelete")
	public String freeBoardDelete(@RequestParam("postNumber") int postNumber, Model model) {
		boardService.FreeBoardDelete(postNumber);
		return "redirect:freeBoardList";
	}

}
