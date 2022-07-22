package ks43team04.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks43team04.dto.Board;
import ks43team04.dto.Event;
import ks43team04.dto.Member;
import ks43team04.mapper.BoardMapper;
import ks43team04.service.BoardService;
import ks43team04.service.MemberService;

@Controller
@RequestMapping("/user/board")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	private final BoardService boardService;
	private final MemberService memberService;
	private final BoardMapper boardMapper;

	public BoardController(BoardService boardService, MemberService memberService, BoardMapper boardMapper) {
		this.boardService = boardService;
		this.memberService = memberService;
		this.boardMapper = boardMapper;
	}



	/*Q&A(문의사항) 삭제하기 */
	@PostMapping("/qnaList")
	public String qnaList(Board board){
		boardService.qnaRemove(board);
		return "redirect:/user/board/qnaList";
	}
	

	/*Q&A(문의사항) 수정*/
	@GetMapping("/qnaModify")
	public String qnaModify(@RequestParam(name = "boardIdx", required = false) String boardIdx
							,@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardSecret", required = false) String boardSecret
							,@RequestParam(name = "memberId", required = false) String memberId
							,@RequestParam(name = "boardTitle", required = false) String boardTitle
							,@RequestParam(name = "boardContent", required = false) String boardContent
							,Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		model.addAttribute("board", board);
		return "/user/board/qnaModify";
	}
	@PostMapping("/qnaModify")
	public String qnaModify(@RequestParam(name = "boardIdx", required = false) String boardIdx
							,@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardSecret", required = false) String boardSecret
							,@RequestParam(name = "memberId", required = false) String memberId
							,@RequestParam(name = "boardTitle", required = false) String boardTitle
							,@RequestParam(name = "boardContent", required = false) String boardContent
							,@RequestParam(name = "updateTime", required = false) String updateTime
							,Board board) {
		boardService.qnaModify(board);
		return "redirect:/user/board/qnaList";
	}


	/*Q&A(문의사항) 작성*/
	@GetMapping("/qnaWrite")
	public String qnaWrite(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) Integer boardIdx
							,Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);
		model.addAttribute("title", "문의등록");
		model.addAttribute("titleName", "문의등록");
		model.addAttribute("member", member);
		return "/user/board/qnaWrite";
	}
	
	@PostMapping("/qnaWrite")
	public String qnaWrite(Board board, HttpSession session
							,RedirectAttributes reAttr, @RequestParam MultipartFile[] boardImgFile, HttpServletRequest request) {
		System.out.println("------------------------게시글 등록 처리-----------------------------");
		String serverName = request.getServerName();
		String fileRealPath = "";
		String sessionId = (String) session.getAttribute("SID");
		
		if("localhost".equals(serverName)) {
			// server 가 localhost 일때 접근
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			System.out.println(System.getProperty("user.dir"));
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			//배포용 주소
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		String boardIdx = boardService.qnaWrite(board, sessionId, boardImgFile, fileRealPath);
		reAttr.addAttribute("boardIdx", boardIdx);
		System.out.println("------------------------게시글 등록 처리 끝-----------------------------");
		
		return "redirect:/user/board/qnaList";
	}
		
	
	/*Q&A(문의사항) 상세 조회*/
	@GetMapping("/qnaDetail")
	public String qnaDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) String boardIdx
							,@RequestParam(name = "memberId", required = false) String memberId
							,HttpSession session
							,Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		int readCount = boardService.readCount(board);
		model.addAttribute("readCount", readCount);
		String sessionId = (String) session.getAttribute("SID");
		String mId = board.getMemberId();
		Member member = memberService.getMemberInfoById(mId);
		model.addAttribute("board", board);
		model.addAttribute("member", member);
		model.addAttribute("sessionId", sessionId);
		return "/user/board/qnaDetail";
	}

	/*비밀글 권한*/
	@GetMapping("/secret")
	public String secret() {
		return "/user/board/secret";
	}
	
	/*Q&A(문의사항) 목록 조회*/
	@GetMapping("/qnaList")
	public String qnaServiceList(Model model, HttpSession session) {
		List<Board> qnaServiceList = boardService.getQnaServiceList();
		List<Board> qnaPickupList = boardService.getQnaPickupList();
		List<Board> qnaPayList = boardService.getQnaPayList();
		List<Board> qnaComplainList = boardService.getQnaComplainList();
		int getQnaServiceListCount = boardMapper.getQnaServiceListCount();
		int getQnaPickupListCount = boardMapper.getQnaPickupListCount();
		int getQnaPayListCount = boardMapper.getQnaPayListCount();
		int getQnaComplainListCount = boardMapper.getQnaComplainListCount();
		String sessionId = (String) session.getAttribute("SID");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		log.info("문의사항 서비스 이용 목록 : {}", qnaServiceList);
		log.info("문의사항 수거 배송 목록 : {}", qnaPickupList);
		log.info("문의사항 결제 포인트 목록 : {}", qnaPayList);
		model.addAttribute("qnaServiceList", qnaServiceList);
		model.addAttribute("qnaPickupList", qnaPickupList);
		model.addAttribute("qnaPayList", qnaPayList);
		model.addAttribute("qnaComplainList", qnaComplainList);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("sessionLevel", sessionLevel);
		model.addAttribute("getQnaServiceListCount", getQnaServiceListCount);	
		model.addAttribute("getQnaPickupListCount", getQnaPickupListCount);	
		model.addAttribute("getQnaPayListCount", getQnaPayListCount);	
		model.addAttribute("getQnaComplainListCount", getQnaComplainListCount);	
		return "/user/board/qnaList";
	}

	/*FAQ(자주 묻는 질문) 목록 조회*/
	@GetMapping("/faqList")
	public String faqList() {
		return "/user/board/faqList";
	}

	
	/*이벤트 상세 조회*/
	@GetMapping("/eventDetail")
	public String eventDetail(@RequestParam(name = "eventCode", required = false) String eventCode,
								Model model) {
		Event event = boardService.eventDetail(eventCode);
		int readCount = boardService.eventreadCount(event);
		model.addAttribute("readCount", readCount);
		model.addAttribute("event", event);
		return "/user/board/eventDetail";
	}
	
	/*이벤트 목록 조회*/
	@GetMapping("/eventList")
	public String eventList(Model model) {
		List<Event> eventList = boardService.getEventListForUser();
		model.addAttribute("eventList", eventList);
		System.out.println("eventList-----"+eventList);
		return "/user/board/eventList";
	}
	
	
	/*공지사항 상세 조회*/
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
								,@RequestParam(name = "boardIdx", required = false) String boardIdx 
								,Model model) {

		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		int readCount = boardService.readCount(board);
		model.addAttribute("readCount", readCount);
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
		model.addAttribute("rowCount", resultMap.get("rowCount"));
		System.out.println("getNoticeList resultMap-----------"+resultMap);
		return "/user/board/noticeList";
	}

}
