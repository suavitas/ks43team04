package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.Board;
import ks43team04.service.BoardService;

@Controller
@RequestMapping("/admin")
public class AdminBoardController {

	private final BoardService boardService;

	public AdminBoardController( BoardService boardService) {
		this.boardService = boardService;

	}
	

	
	
	
	//Q&A 목록
	@GetMapping("/qnaList")
	public String qnaList() {
		return "admin/qnaList";
	}
	
	
	//이벤트 목록
	@GetMapping("/eventList")
	public String eventList() {
		return "admin/eventList";
	}
	
	
	//공지사항 목록
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		List<Board> noticeList = boardService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "admin/noticeList";
	}
	
}