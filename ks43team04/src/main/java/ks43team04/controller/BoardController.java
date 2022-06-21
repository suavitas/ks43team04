package ks43team04.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks43team04.dto.Board;
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
	public String noticeWrite() {
		
		return "/user/board/noticeWrite";
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
	public String noticeDetail(@RequestParam(name="boardCode", required = false) String boardCode
							  ,Model model) {
		
		Board board = boardService.getBoardDetailByCode(boardCode);
		
		model.addAttribute("board", board);
		
		
		return "/user/board/noticeDetail";
	}
	
	/**
	 * Q&A > 상세글 조회
	 */
	 
	@GetMapping("/qnaDetail")
	public String qnaDetail(@RequestParam(name="boardCode", required = false) String boardCode
			  				,Model model) {
		
	Board board = boardService.getBoardDetailByCode(boardCode);
	
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

