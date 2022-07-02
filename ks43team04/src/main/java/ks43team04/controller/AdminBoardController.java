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
import ks43team04.dto.LaundryList;
import ks43team04.dto.Member;
import ks43team04.dto.Review;
import ks43team04.service.BoardService;
import ks43team04.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminBoardController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminBoardController.class);

	private final MemberService memberService;
	private final BoardService boardService;

	public AdminBoardController( BoardService boardService, MemberService memberService) {
		this.boardService = boardService;
		this.memberService = memberService;
	}
	
	/*공지사항 삭제*/
	@PostMapping("/noticeList")
	public String noticeList(Board board) {
		boardService.noticeRemove(board);
		return "redirect:/admin/noticeList";
	}
	
	/*공지사항 수정*/
	@GetMapping("/noticeModify")
	public String noticeModify(@RequestParam(name = "boardIdx", required = false) String boardIdx
								,@RequestParam(name = "memberId", required = false) String memberId
								,@RequestParam(name = "boardTitle", required = false) String boardTitle
								,@RequestParam(name = "boardContent", required = false) String boardContent
								,@RequestParam(name = "boardAddFile", required = false) String boardAddFile
								,@RequestParam(name = "boardAddFileName", required = false) String boardAddFileName
								,@RequestParam(name = "boardAddFileVol", required = false) String boardAddFileVol
								,@RequestParam(name = "updateTime", required = false) String updateTime
								,Model model) {
		model.addAttribute("boardIdx", boardIdx);
		model.addAttribute("memberId", memberId);
		model.addAttribute("boardTitle", boardTitle);
		model.addAttribute("boardContent", boardContent);
		model.addAttribute("boardAddFile", boardAddFile);
		model.addAttribute("boardAddFileName", boardAddFileName);
		model.addAttribute("boardAddFileVol", boardAddFileVol);
		model.addAttribute("updateTime", updateTime);
		return "/admin/noticeModify";
	}
	
	@PostMapping("/noticeModify")
	public String noticeModify(@RequestParam(name = "boardIdx", required = false) String boardIdx
								,@RequestParam(name = "memberId", required = false) String memberId
								,@RequestParam(name = "boardTitle", required = false) String boardTitle
								,@RequestParam(name = "boardContent", required = false) String boardContent
								,@RequestParam(name = "boardAddFile", required = false) String boardAddFile
								,@RequestParam(name = "boardAddFileName", required = false) String boardAddFileName
								,@RequestParam(name = "boardAddFileVol", required = false) String boardAddFileVol
								,@RequestParam(name = "updateTime", required = false) String updateTime
								,Board board) {
		boardService.noticeModify(board);
		System.out.println("noticeModify----------"+board);
		return "redirect:/admin/noticeList";
	}
	
	
	/*고장 신고 등록*/
	@GetMapping("/asForm")
	public String asForm(Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);
		List<LaundryList> getMemberLaundryList = boardService.getMemberLaundryList(sessionId);
		model.addAttribute("title", "AS등록");
		model.addAttribute("titleName", "AS등록");
		model.addAttribute("member", member);
		model.addAttribute("getMemberLaundryList", getMemberLaundryList);
		return "/admin/asForm";
	}
	
	@PostMapping("/asForm")
	public String asForm(As as, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.asForm(as, sessionId);
		System.out.println("as입니다"+as);
		return "redirect:/admin/asListById";
	}
	
	/*나의 고장 신고 내역 확인*/
	@GetMapping("/asListById")
	public String asListById(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		Member member = memberService.getMemberInfoById(sessionId);
		
		List<LaundryList> getMemberLaundryList = boardService.getMemberLaundryList(sessionId);
		List<As> asListById = boardService.asListById(sessionId);
		
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("getMemberLaundryList", getMemberLaundryList);
		model.addAttribute("asListById", asListById);
		System.out.println(asListById);
		return "admin/asListById";
	}
	
	/*고장 신고 상세 조회*/
	@GetMapping("/asDetail")
	public String asDetail(@RequestParam(name = "asCode", required = false) String asCode
							,Model model) {
		As as = boardService.getAsDetail(asCode);
		
		
		model.addAttribute("as", as);
		log.info("as목록 : {}", as);
		System.out.println(as);
		return "admin/asDetail";
	}
	
	/*고장 신고 목록*/
	@GetMapping("/asList")
	public String asList(Model model) {
		List<As> asList = boardService.getAsList();
		List<As> readyAsList = boardService.readyAsList();
		List<As> startAsList = boardService.startAsList();
		List<As> endAsList = boardService.endAsList();
		model.addAttribute("asList", asList);
		model.addAttribute("readyAsList", readyAsList);
		model.addAttribute("startAsList", startAsList);
		model.addAttribute("endAsList", endAsList);
		System.out.println(asList);
		return "admin/asList";
	}
	/*고장 신고 접수*/
	@PostMapping("/asList")
	public String asList(As as) {
		boardService.asReceipt(as);
		return "redirect:/admin/asList";
	}
	
	/*리뷰 목록 조회*/
	@GetMapping("/review")
	public String review(Model model) {
		List<Review> reviewList = boardService.getReviewList();
		model.addAttribute("reviewList", reviewList);
		return "admin/review";
	}
	/*Q&A(문의사항)답글 작성*/
	@GetMapping("/qnaComment")
	public String qnaComment(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) int boardIdx
							, Model model) {
		model.addAttribute("title", "답변등록");
		model.addAttribute("titleName", "답변등록");
		model.addAttribute("boardMenuCode", boardMenuCode);
		model.addAttribute("boardIdx", boardIdx);
		return "admin/qnaComment";
	}
	
	@PostMapping("/qnaComment")
	public String qnaComment(Board board, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.qnaComment(board, sessionId);
		boardService.commentComplete(board);
		return "redirect:/admin/qnaList";
	}
	
	/*Q&A(문의사항) 상세 조회*/
	@GetMapping("/qnaDetail")
	public String qnaDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) int boardIdx, Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		model.addAttribute("board", board);
		return "/admin/qnaDetail";
	}
	
	/*Q&A(문의사항) 목록 조회*/
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
	
	/*이벤트 등록*/
	@GetMapping("/eventForm")
	public String eventForm(Model model) {
		model.addAttribute("title", "이벤트 등록");
		model.addAttribute("titleName", "이벤트 등록");
		return "admin/eventForm";
	}	
	@PostMapping("/eventForm")
	public String eventForm(Event event, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.eventForm(event, sessionId);
		return "redirect:/admin/eventList";
	}
	
	/*이벤트 상세 조회*/
	@GetMapping("/eventDetail")
		public String eventDetail(@RequestParam(name = "eventCode", required = false) String eventCode
								, Model model) {
		Event event = boardService.eventDetail(eventCode);
		model.addAttribute("event", event);
		return "admin/eventDetail";
		}		

	/*이벤트 목록 조회*/
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
	
	/*공지사항 작성*/
	@GetMapping("/noticeForm")
	public String noticeForm(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
								,@RequestParam(name = "boardIdx", required = false) Integer boardIdx
								,Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);
	
		model.addAttribute("title", "공지등록");
		model.addAttribute("titleName", "공지등록");
		model.addAttribute("member", member);
		System.out.println("noticeForm get====="+member);
		return "/admin/noticeForm";
	}
	
	@PostMapping("/noticeForm")
	public String noticeForm(Board board, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.noticeForm(board, sessionId);
		log.info("공지 등록 data : {}", board);
		log.info("화면에서 입력받은 data: {}, boardIdx");
		System.out.println("board+++++" +board);
		return "redirect:/admin/noticeList";
	}
	
	/*공지사항 상세 조회*/
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
								,@RequestParam(name = "boardIdx", required = false) int boardIdx
								, Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		model.addAttribute("board", board);
		System.out.println("board--------------"+board);
		return "admin/noticeDetail";
	}
	
	/*공지사항 목록 조회*/
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		List<Board> noticeList = boardService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "admin/noticeList";
	}
	
}