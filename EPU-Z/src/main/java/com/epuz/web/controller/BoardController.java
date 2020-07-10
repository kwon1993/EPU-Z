package com.epuz.web.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.epuz.web.domain.PageMaker;
import com.epuz.web.domain.PageSet;
import com.epuz.web.dto.FreeBoardModifyDTO;
import com.epuz.web.dto.FreeBoardRegistrationDTO;
import com.epuz.web.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	public BoardService boardService;
	
	@GetMapping("/freeBoardList")
	public String freeBoardList(PageSet pageSet, Model model) {
		model.addAttribute("freeBoardList", boardService.freeBoardList(pageSet));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageSet(pageSet);
		pageMaker.setTotalCount(boardService.freeBoardListCount(pageSet));
		model.addAttribute("pageMaker", pageMaker);
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
	
//	@GetMapping("/fileupload")
	@PostMapping("/fileupload")
	@ResponseBody
	public void profileUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 업로드할 폴더 경로
//		String realFolder = request.getSession().getServletContext().getRealPath("/images");
		String realFolder = "/images";
		UUID uuid = UUID.randomUUID();

		// 업로드할 파일 이름
		String org_filename = file.getOriginalFilename();
		String str_filename = uuid.toString() + org_filename;

		System.out.println("원본 파일명 : " + org_filename);
		System.out.println("저장할 파일명 : " + str_filename);

		String filepath = realFolder + "/" + str_filename;
		System.out.println("파일경로 : " + filepath);

		File f = new File(filepath);
		if (!f.exists()) {
			f.mkdirs();
		}
		file.transferTo(f);
		out.println(filepath);
		out.close();
	}
	
//	@PostMapping("/fileupload")
//	@ResponseBody
//	public void fileUpload(@RequestPart MultipartFile files) {
//		try {
//			String baseDir = "/images";
//			files.transferTo(new File(baseDir + "/" + files.getOriginalFilename()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@PostMapping("/image")
//	@ResponseBody
//	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file){
//		try {
//			UploadFile uploadFile = imageService.store(file);
//			return ResponseEntity.ok().body("/image/" + uploadFile.getId());
//		} catch(Exception e) {
//			return ResponseEntity.badRequest().build();
//		}
//	}
	

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
