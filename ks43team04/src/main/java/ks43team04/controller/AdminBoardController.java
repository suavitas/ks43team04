package ks43team04.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.As;
import ks43team04.dto.Board;
import ks43team04.dto.Event;
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
	public String asForm(Model model) {
		model.addAttribute("title", "AS등록");
		model.addAttribute("titleName", "AS등록");
		return "/admin/asForm";
	}
	@PostMapping("/asForm")
	public String asForm(As as, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.asForm(as, sessionId);
		log.info("as 등록 data : {}", as);
		log.info("화면에서 입력받은 data: {}, laundryCode");
		return "redirect:/admin/asListById";
	}
	
	//나의 고장신고접수 내역 확인
		@GetMapping("/asListById")
		public String asListById() {
			return "admin/asListById";
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
	//Q&A 상세글 조회
	@GetMapping("/qnaDetail")
	public String qnaDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "totalNo", required = false) int totalNo, Model model) {

		Board board = boardService.getBoardDetailByCode(boardMenuCode, totalNo);

		model.addAttribute("board", board);
		return "/admin/qnaDetail";
	}

	

	//Q&A 목록
	@GetMapping("/qnaList")
	public String qnaList(Model model) {
		List<Board> qnaServiceList = boardService.getQnaServiceList();
		List<Board> qnaPickupList = boardService.getQnaPickupList();
		List<Board> qnaPayList = boardService.getQnaPayList();
		List<Board> qnaComplainList = boardService.getQnaComplainList();

		log.info("문의사항 서비스 이용 목록 : {}", qnaServiceList);
		log.info("문의사항 수거 배송 목록 : {}", qnaPickupList);
		log.info("문의사항 결제 포인트 목록 : {}", qnaPayList);

		model.addAttribute("qnaServiceList", qnaServiceList);
		model.addAttribute("qnaPickupList", qnaPickupList);
		model.addAttribute("qnaPayList", qnaPayList);
		model.addAttribute("qnaComplainList", qnaComplainList);
		
		return "admin/qnaList";
	}
	
	//이벤트 작성
	@GetMapping("/eventForm")
	public String eventForm() {
		return "admin/eventForm";
	}
	
	//이벤트 상세조회
	@GetMapping("/eventDetail")
		public String eventDetail(@RequestParam(name = "eventCode", required = false) String eventCode
								, Model model) {
		Event event = boardService.eventDetail(eventCode);
		model.addAttribute("event", event);
			return "admin/eventDetail";
		}		

	//이벤트 목록
	@GetMapping("/eventList")
	public String eventList(Model model) {
		List<Event> eventList = boardService.getEventList();
		List<Event> runEventList = boardService.runEventList();
		List<Event> endEventList = boardService.endEventList();
		
		model.addAttribute("eventList", eventList);
		model.addAttribute("runEventList", runEventList);
		model.addAttribute("endEventList", endEventList);
		return "admin/eventList";
	}
	
	//공지사항 작성
	@GetMapping("/noticeForm")
	public String noticeForm(Model model) {

		model.addAttribute("title", "공지등록");
		model.addAttribute("titleName", "공지등록");
		return "/admin/noticeForm";
	}
	@PostMapping("/noticeForm")
	public String noticeForm(Board board, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.noticeForm(board, sessionId);

		log.info("공지 등록 data : {}", board);
		log.info("화면에서 입력받은 data: {}, boardCode");

		return "redirect:/admin/noticeList";
	}
	
	//공지사항 상세글 조회
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
								,@RequestParam(name = "totalNo", required = false) int totalNo
								, Model model) {

		Board board = boardService.getBoardDetailByCode(boardMenuCode, totalNo);

		model.addAttribute("board", board);

		return "admin/noticeDetail";
	}
	
	//공지사항 목록
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		List<Board> noticeList = boardService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "admin/noticeList";
	}
	
}