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

import ks43team04.dto.Board;
import ks43team04.mapper.BoardMapper;
import ks43team04.service.BoardService;

@Controller
@RequestMapping("/user/board")
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	private final BoardService boardService;
	private final BoardMapper boardMapper;
	
	public BoardController(BoardService boardService, BoardMapper boardMapper) {
		this.boardService = boardService;
		this.boardMapper = boardMapper;
	}
	
	/**
	 * Qna > 답글작성
	 */
	@GetMapping("/qnaComment")
	public String qnaComment() {
		
		return "/user/board/qnaComment";
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
	

	/**
	 * 이벤트 > 글 작성하기
	 */
	@GetMapping("/eventWrite")
	public String eventWrite(){
		
		return "/user/board/eventWrite";
	}
	
	
	
	/**
	 * 공지사항 > 글 작성하기
	 */
	
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
		
		

	
	
	/**
	 * Q&A > 문의하기
	 */
	@GetMapping("/qnaWrite")
	public String qnaWrite() {
		
		return "/user/board/qnaWrite";
	}
	
	
	
	/**
	 * 공지사항 > 상세글 조회 
	 */
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(name="boardMenuCode", required = false) String boardMenuCode
							  ,@RequestParam(name="boardParentNo", required = false) int boardParentNo
							  ,Model model) {
		
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardParentNo);
		
		model.addAttribute("board", board);
		
		
		return "/user/board/noticeDetail";
	}
	
	/**
	 * Q&A > 상세글 조회
	 */
	 
	@GetMapping("/qnaDetail")
	public String qnaDetail(@RequestParam(name="boardMenuCode", required = false) String boardMenuCode
							  ,@RequestParam(name="boardParentNo", required = false) int boardParentNo
							  ,Model model) {
						
	Board board = boardService.getBoardDetailByCode(boardMenuCode, boardParentNo);
	
	model.addAttribute("board", board);
			return "/user/board/qnaDetail";
		}

	/**
	 * 메인 > 문의사항 목록 조회
	 */
	@GetMapping("/qnaList")
	public String qnaServiceList(Model model) {
		List<Board> qnaServiceList = boardService.getQnaServiceList();
		List<Board> qnaPickupList = boardService.getQnaPickupList();
		List<Board> qnaPayList = boardService.getQnaPayList();
		List<Board> qnaComplainList = boardService.getQnaComplainList();
		
		
		
		log.info("문의사항 서비스 이용 목록 : {}", qnaServiceList);
		log.info("문의사항 수거 배송 목록 : {}", qnaPickupList);
		log.info("문의사항 결제 포인트 목록 : {}", qnaPayList);
		log.info("문의사항 서비스 불만족 목록 : {}", qnaComplainList);
		
		
		model.addAttribute("qnaServiceList", qnaServiceList);
		model.addAttribute("qnaPickupList", qnaPickupList);
		model.addAttribute("qnaPayList", qnaPayList);
		model.addAttribute("qnaComplainList", qnaComplainList);
		
		return "/user/board/qnaList";
	}	
	
	/**
	 * 메인 > FAQ(자주 묻는 질문) 목록 조회
	 */
	@GetMapping("/faqList")
	public String faqList() {
		return "/user/board/faqList";
	}
	
	/**
	 * 메인 > 이벤트 목록 조회
	 */
	@GetMapping("/eventList")
	public String eventList() {
		return "/user/board/eventList";
	}

	/**
	 * 메인 > 공지사항 목록 조회
	 * */
	@GetMapping("/noticeList")
	public String noticeList(Model model) {
		List<Board> noticeList = boardService.getNoticeList();
			log.info("공지사항 전체 목록: {}", noticeList);
			model.addAttribute("noticeList", noticeList);
			return "/user/board/noticeList";
		}
	


	
	}
