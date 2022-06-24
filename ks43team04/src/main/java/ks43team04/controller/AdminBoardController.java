package ks43team04.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.As;
import ks43team04.dto.Board;
import ks43team04.dto.Laundry;
import ks43team04.service.BoardService;

@Controller
@RequestMapping("/admin")
public class AdminBoardController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminBoardController.class);

	private final BoardService boardService;

	public AdminBoardController( BoardService boardService) {
		this.boardService = boardService;

	}
	
	//고장신고접수등록
	@GetMapping("/asForm")
	public String asForm() {
		return "admin/asForm";
	}
	
	//고장신고접수 상세조회
	@GetMapping("/asDetail")
	public String asDetail(@RequestParam(name = "asCode", required = false) String asCode
							, Model model) {
		As as = boardService.getAsDetail(asCode);
		model.addAttribute("as", as);
		log.info("as목록 : {}", as);
		System.out.println(as);
		return "admin/asDetail";
	}
	
	
	
	//고장신고접수목록
	@GetMapping("/asList")
	public String asList(Model model) {
		List<As> asList = boardService.getAsList();
		model.addAttribute("asList", asList);
		System.out.println(asList);
		return "admin/asList";
	}
	
	
	//리뷰 목록
	@GetMapping("/review")
	public String review() {
		
		return "admin/review";
	}
	

	//Q&A 목록
	@GetMapping("/qnaList")
	public String qnaList() {
		return "admin/qnaList";
	}
	
	//이벤트 작성
	@GetMapping("/eventForm")
	public String eventForm() {
		return "admin/eventForm";
	}
	
	
	//이벤트 목록
	@GetMapping("/eventList")
	public String eventList() {
		return "admin/eventList";
	}
	
	//공지사항 작성
	@GetMapping("/noticeForm")
	public String noticeForm() {
		return "/admin/noticeForm";
	}
	
	
	//공지사항 목록
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		List<Board> noticeList = boardService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "admin/noticeList";
	}
	
}