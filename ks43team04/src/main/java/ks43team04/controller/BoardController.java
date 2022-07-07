package ks43team04.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.Board;
import ks43team04.dto.Event;
import ks43team04.service.BoardService;

@Controller
@RequestMapping("/user/board")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}



	/**
	 * Qna > 삭제하기
	 */
	@GetMapping("/qnaRemove")
	public String qnaRemove() {

		return "/user/board/qnaRemove";
	}

	/**
	 * Qna > 수정하기
	 */
	@GetMapping("/qnaModify")
	public String qnaModify() {

		return "/user/board/qnaModify";
	}

	/**
	 * 공지사항 > 글 삭제하기
	 */
	@GetMapping("/noticeRemove")
	public String noticeRemove() {

		return "/user/board/noticeRemove";
	}

	/**
	 * 공지사항 > 글 수정하기
	 */
	@GetMapping("/noticeModify")
	public String noticeModify() {

		return "/user/board/noticeModify";
	}

	



	/*Q&A(문의사항) 답글 작성*/
	@GetMapping("/qnaComment")
	public String qnaComment(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) int boardIdx
							, Model model) {
		log.info("답글 작성 : {}", boardMenuCode);
		log.info("답글 작성 : {}", boardIdx);
		model.addAttribute("title", "답변등록");
		model.addAttribute("titleName", "답변등록");
		model.addAttribute("boardMenuCode", boardMenuCode);
		model.addAttribute("boardIdx", boardIdx);
		return "/user/board/qnaComment";
	}
	@PostMapping("/qnaComment")
	public String qnaComment(Board board, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.qnaComment(board, sessionId);	
		boardService.commentComplete(board);
		return "redirect:/user/board/qnaList"; 
	}	
	
	/*Q&A(문의사항) 작성*/
	@GetMapping("/qnaWrite")
	public String qnaWrite(Model model) {
		model.addAttribute("title", "문의등록");
		model.addAttribute("titleName", "문의등록");
		return "/user/board/qnaWrite";
	}
	
	@PostMapping("/qnaWrite")
	public String qnaWrite(Board board, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.qnaWrite(board, sessionId);
		log.info("문의사항 등록 data : {}", board);
		log.info("화면에서 입력받은 data : {}, boardCode");
		return "redirect:/user/board/qnaList";
	}
	
	/*Q&A(문의사항) 상세 조회*/
	@GetMapping("/qnaDetail")
	public String qnaDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) int boardIdx, Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		model.addAttribute("board", board);
		return "/user/board/qnaDetail";
	}

	/*Q&A(문의사항) 목록 조회*/
	@GetMapping("/qnaList")
	public String qnaServiceList(Model model) {
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
		return "/user/board/qnaList";
	}

	/*FAQ(자주 묻는 질문) 목록 조회*/
	@GetMapping("/faqList")
	public String faqList() {
		return "/user/board/faqList";
	}

	/*이벤트 작성*/
	@GetMapping("/eventWrite")
	public String eventWrite(Model model) {
		model.addAttribute("title", "이벤트 등록");
		model.addAttribute("titleName", "이벤트 등록");
		return "/user/board/eventWrite";
	}
	@PostMapping("/eventWrite")
	public String eventWrite(Event event, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.eventForm(event, sessionId);
		return "redirect:/user/board/eventList";
	}
	
	/*이벤트 상세 조회*/
	@GetMapping("/eventDetail")
	public String eventDetail(@RequestParam(name = "eventCode", required = false) String eventCode,
								Model model) {
		Event event = boardService.eventDetail(eventCode);
		model.addAttribute("event", event);
		return "/user/board/eventDetail";
	}
	
	/*이벤트 목록 조회*/
	@GetMapping("/eventList")
	public String eventList(Model model) {
		List<Event> eventList = boardService.getEventList();
		model.addAttribute("eventList", eventList);
		return "/user/board/eventList";
	}
	
	/*공지사항 작성*/
	@GetMapping("/noticeWrite")
	public String noticeWrite(Model model) {
		model.addAttribute("title", "공지등록");
		model.addAttribute("titleName", "공지등록");
		return "/user/board/noticeWrite";
	}

	@PostMapping("/noticeWrite")
	public String noticeWrite(Board board, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		boardService.noticeWrite(board, sessionId);
		log.info("공지 등록 data : {}", board);
		log.info("화면에서 입력받은 data: {}, boardCode");
		return "redirect:/user/board/noticeList";
	}
	
	/*공지사항 상세 조회*/
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
								,@RequestParam(name = "boardIdx", required = false) int boardIdx 
								,Model model) {

		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		model.addAttribute("board", board);
		return "/user/board/noticeDetail";
	}

	/*공지사항 목록 조회*/
	@GetMapping("/noticeList")
	public String noticeList(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage 
								,Model model) {
		
		Map<String, Object> resultMap = boardService.getNoticeList(currentPage);
		
		model.addAttribute("getNoticeList", resultMap.get("getNoticeList"));
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("endPageNum", resultMap.get("endPageNum"));
		return "/user/board/noticeList";
	}

}
