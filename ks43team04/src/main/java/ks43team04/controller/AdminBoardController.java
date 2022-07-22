package ks43team04.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks43team04.dto.As;
import ks43team04.dto.Board;
import ks43team04.dto.Event;
import ks43team04.dto.Laundry;
import ks43team04.dto.LaundryList;
import ks43team04.dto.Member;
import ks43team04.dto.Review;
import ks43team04.mapper.AsMapper;
import ks43team04.mapper.BoardMapper;
import ks43team04.service.BoardService;
import ks43team04.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminBoardController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminBoardController.class);

	private final MemberService memberService;
	private final BoardService boardService;
	private final BoardMapper boardMapper;
	private final AsMapper asMapper;

	public AdminBoardController( BoardService boardService, MemberService memberService, BoardMapper boardMapper, AsMapper asMapper) {
		this.boardService = boardService;
		this.memberService = memberService;
		this.boardMapper = boardMapper;
		this.asMapper = asMapper;
	}
	
	/*고장 신고 등록*/
	@GetMapping("/asForm")
	public String asForm(@RequestParam(name = "asCode", required = false) String asCode
							,Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);
		List<Laundry> getMemberLaundryList = boardService.getMemberLaundryList(sessionId);
		model.addAttribute("title", "AS등록");
		model.addAttribute("titleName", "AS등록");
		model.addAttribute("member", member);
		model.addAttribute("getMemberLaundryList", getMemberLaundryList);
		return "/admin/asForm";
	}
	
	@PostMapping("/asForm")
	public String asForm(As as, HttpSession session
							,RedirectAttributes reAttr, @RequestParam MultipartFile[] boardImgFile, HttpServletRequest request) {
		System.out.println("------------------------AS 등록 처리-----------------------------");
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		String sessionId = (String)session.getAttribute("SID");
		
		if("localhost".equals(serverName)) {
			// server 가 localhost 일때 접근
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			System.out.println(System.getProperty("user.dir"));
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			//배포용 주소
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		String asCode = boardService.asForm(as, sessionId, boardImgFile, fileRealPath);
		reAttr.addAttribute("asCode", asCode);
		System.out.println("------------------------AS 등록 처리 끝-----------------------------");
		
		return "redirect:/admin/asListById";
	}
		
	
	/*나의 고장 신고 내역 확인*/
	@GetMapping("/asListById")
	public String asListById(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionName = (String) session.getAttribute("SNAME");
		
		List<Laundry> getMemberLaundryList = boardService.getMemberLaundryList(sessionId);
		List<As> asListById = boardService.asListById(sessionId);
		int asListByIdCount = asMapper.asListByIdCount(sessionId);
		
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("getMemberLaundryList", getMemberLaundryList);
		model.addAttribute("asListById", asListById);
		model.addAttribute("asListByIdCount", asListByIdCount);
		System.out.println(asListById);
		return "admin/asListById";
	}
	
	/*고장 신고 상세 조회*/
	@GetMapping("/asDetail")
	public String asDetail(@RequestParam(name = "asCode", required = false) String asCode
							,Model model, HttpSession session) {
		As as = boardService.getAsDetail(asCode);
		String mId = as.getMemberId();
		Member member = memberService.getMemberInfoById(mId);
		String sessionId = (String) session.getAttribute("SID");
		Member ssmember = memberService.getMemberInfoById(sessionId);
		

		model.addAttribute("member", member);
		model.addAttribute("ssmember", ssmember);
		model.addAttribute("as", as);
		log.info("as목록 : {}", as);
		System.out.println(as);
		System.out.println(ssmember);
		return "admin/asDetail";
	}
	
	/*고장 신고 목록*/
	@GetMapping("/asList")
	public String asList(Model model) {
		List<As> asList = boardService.getAsList();
		List<As> readyAsList = boardService.readyAsList();
		List<As> startAsList = boardService.startAsList();
		List<As> endAsList = boardService.endAsList();
		int getAsListCount = asMapper.getAsListCount();
		int readyAsListCount = asMapper.readyAsListCount();
		int startAsListCount = asMapper.startAsListCount();
		int endAsListCount = asMapper.endAsListCount();
		model.addAttribute("asList", asList);
		model.addAttribute("readyAsList", readyAsList);
		model.addAttribute("startAsList", startAsList);
		model.addAttribute("endAsList", endAsList);
		model.addAttribute("getAsListCount", getAsListCount);
		model.addAttribute("readyAsListCount", readyAsListCount);
		model.addAttribute("startAsListCount", startAsListCount);
		model.addAttribute("endAsListCount", endAsListCount);
		System.out.println(asList);
		return "admin/asList";
	}
	
	/*고장 신고 수정*/
	@GetMapping("/asModify")
	public String asModify(@RequestParam(name = "asCode", required = false) String asCode
							,@RequestParam(name = "memberId", required = false) String memberId
							,@RequestParam(name = "asTitle", required = false) String asTitle
							,@RequestParam(name = "asContent", required = false) String asContent
							,@RequestParam(name = "asState", required = false) String asState
							,@RequestParam(name = "updateTime", required = false) String updateTime
							,Model model, HttpSession session) {
		As as = boardService.getAsDetail(asCode);
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);
		List<Laundry> getMemberLaundryList = boardService.getMemberLaundryList(sessionId);
		model.addAttribute("member", member);
		model.addAttribute("getMemberLaundryList", getMemberLaundryList);
		model.addAttribute("as", as);
		model.addAttribute("asCode", asCode);
		model.addAttribute("memberId", memberId);
		model.addAttribute("asTitle", asTitle);
		model.addAttribute("asContent", asContent);
		model.addAttribute("asState", asState);
		model.addAttribute("updateTime", updateTime);
		System.out.println("getMemberLaundryList>>>>>>"+getMemberLaundryList);
		return "/admin/asModify";
	}
	@PostMapping("/asModify")
	public String asModify(@RequestParam(name = "asCode", required = false) String asCode
							,@RequestParam(name = "memberId", required = false) String memberId
							,@RequestParam(name = "asTitle", required = false) String asTitle
							,@RequestParam(name = "asContent", required = false) String asContent
							,@RequestParam(name = "asState", required = false) String asState
							,@RequestParam(name = "updateTime", required = false) String updateTime
							,As as) {
		boardService.asModify(as);
		return "redirect:/admin/asListById";
	}
	
	/*고장 신고 접수, 완료, 방문(예정일)변경, 삭제*/
	@PostMapping("/asList")
	public String asList(@RequestParam(name = "asCode", required = false) String asCode
						,@RequestParam(name = "asState", required = false) String asState
						,HttpSession session, As as) {
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);		
		if("대기".equals(as.getAsState())) {
			if("level_code_00".equals(member.getLevelCode())) {
				boardService.asReceipt(as);					
			}else if("level_code_02".equals(member.getLevelCode())) {				
				boardService.asDel(as);			
			}
		}else if("접수".equals(as.getAsState())) {
			boardService.asEnd(as);
			boardService.asVisitChange(as);
		}
		System.out.println(as.getAsState()+"<=============asStateGet");
		System.out.println("상태"+asState);
		System.out.println("시간"+as.getVisitTime());
		return "redirect:/admin/asList";
	}
	
	/*리뷰 목록 조회*/
	@GetMapping("/review")
	public String review(@RequestParam(name = "reviewCode", required = false) String reviewCode
							,Model model, HttpSession session) {
		List<Review> reviewList = boardService.getReviewList();
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("member", member);
		model.addAttribute("reviewCode", reviewCode);
		return "admin/review";
	}
	
	/*리뷰 삭제*/
	@PostMapping("/review")
	public String rvdel(String reviewCode) {
		boardService.rvDel(reviewCode);
		return "redirect:/admin/review";
	}
	
	/*Q&A(문의사항)답글 삭제*/
	@PostMapping("/qnaList")
	public String qnaList(Board board) {
		boardService.qnaRemove(board);
		return "redirect:/admin/qnaList";
	}
	
	/*Q&A(문의사항)답글 수정*/
	@GetMapping("/qnaCommentModify")
	public String qnaCommentModify(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
									,@RequestParam(name = "boardIdx", required = false) String boardIdx
									,@RequestParam(name = "boardSecret", required = false) String boardSecret
									,@RequestParam(name = "memberId", required = false) String memberId
									,@RequestParam(name = "boardTitle", required = false) String boardTitle
									,@RequestParam(name = "boardContent", required = false) String boardContent							
									, Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		model.addAttribute("board", board);
		System.out.println("board 코멘트 수정"+board);
		return "/admin/board/qnaCommentModify";
	}
	@PostMapping("qnaCommentModify")
	public String qnaCommentModify(@RequestParam(name = "boardIdx", required = false) String boardIdx
									,@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
									,@RequestParam(name = "boardSecret", required = false) String boardSecret
									,@RequestParam(name = "memberId", required = false) String memberId
									,@RequestParam(name = "boardTitle", required = false) String boardTitle
									,@RequestParam(name = "boardContent", required = false) String boardContent
									,@RequestParam(name = "updateTime", required = false) String updateTime
									,Board board) {
		boardService.qnaCommentModify(board);
		return "redirect:/admin/qnaList";
	}

	/*Q&A(문의사항)답글 작성*/
	@GetMapping("/qnaComment")
	public String qnaComment(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) String boardIdx
							, Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);		
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		model.addAttribute("title", "답변등록");
		model.addAttribute("titleName", "답변등록");
		model.addAttribute("member", member);
		model.addAttribute("boardMenuCode", boardMenuCode);
		model.addAttribute("boardIdx", boardIdx);
		model.addAttribute("boardGroupNo", board.getBoardGroupNo());
		model.addAttribute("boardSecret", board.getBoardSecret());
		return "/admin/board/qnaComment";
	}
	
	@PostMapping("/qnaComment")
	public String qnaComment(Board board, HttpSession session
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
		
		String boardIdx = boardService.qnaComment(board, sessionId, boardImgFile, fileRealPath);
		boardService.commentComplete(board);
		reAttr.addAttribute("boardIdx", boardIdx);
		System.out.println("------------------------게시글 등록 처리 끝-----------------------------");
		
		return "redirect:/admin/qnaList";
	}
	
	
	/*Q&A(문의사항) 상세 조회*/
	@GetMapping("/qnaDetail")
	public String qnaDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
							,@RequestParam(name = "boardIdx", required = false) String boardIdx
							, Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		int readCount = boardService.readCount(board);
		String mId = board.getMemberId();
		Member member = memberService.getMemberInfoById(mId);
		model.addAttribute("readCount", readCount);
		model.addAttribute("board", board);
		model.addAttribute("member", member);
		System.out.println("board상세조회"+board);
		return "/admin/board/qnaDetail";
	}
	
	/*Q&A(문의사항) 목록 조회*/
	@GetMapping("/qnaList")
	public String qnaList(Model model) {
		List<Board> qnaServiceList = boardService.getQnaServiceList();
		List<Board> qnaPickupList = boardService.getQnaPickupList();
		List<Board> qnaPayList = boardService.getQnaPayList();
		List<Board> qnaComplainList = boardService.getQnaComplainList();
		int getQnaServiceListCount = boardMapper.getQnaServiceListCount();
		int getQnaPickupListCount = boardMapper.getQnaPickupListCount();
		int getQnaPayListCount = boardMapper.getQnaPayListCount();
		int getQnaComplainListCount = boardMapper.getQnaComplainListCount();
		log.info("문의사항 서비스 이용 목록 : {}", qnaServiceList);
		log.info("문의사항 수거 배송 목록 : {}", qnaPickupList);
		log.info("문의사항 결제 포인트 목록 : {}", qnaPayList);
		model.addAttribute("qnaServiceList", qnaServiceList);
		model.addAttribute("qnaPickupList", qnaPickupList);
		model.addAttribute("qnaPayList", qnaPayList);
		model.addAttribute("qnaComplainList", qnaComplainList);		
		model.addAttribute("getQnaServiceListCount", getQnaServiceListCount);	
		model.addAttribute("getQnaPickupListCount", getQnaPickupListCount);	
		model.addAttribute("getQnaPayListCount", getQnaPayListCount);	
		model.addAttribute("getQnaComplainListCount", getQnaComplainListCount);	
		return "/admin/board/qnaList";
	}
	
	/*이벤트 삭제*/
	@PostMapping("/eventList")
	public String eventList(Event event) {
		boardService.eventRemove(event);
		return "redirect:/admin/eventList";
	}
	
	/*이벤트 수정*/
	@GetMapping("/eventModify")
	public String eventModify(@RequestParam(name = "eventCode", required = false) String eventCode
								,@RequestParam(name = "eventState", required = false) String eventState
								,@RequestParam(name = "memberId", required = false) String memberId
								,@RequestParam(name = "eventTitle", required = false) String eventTitle
								,@RequestParam(name = "eventContent", required = false) String eventContent
								,@RequestParam(name = "updateTime", required = false) String updateTime
								,Model model) {
		Event event = boardService.eventDetail(eventCode);
		model.addAttribute("event", event);
		/*model.addAttribute("eventCode", eventCode);
		model.addAttribute("eventState", eventState);
		model.addAttribute("memberId", memberId);
		model.addAttribute("eventTitle", eventTitle);
		model.addAttribute("eventContent", eventContent);
		model.addAttribute("updateTime", updateTime);*/
		return "/admin/board/eventModify";
	}
	
	@PostMapping("/eventModify")
	public String eventModify(@RequestParam(name = "eventCode", required = false) String eventCode
								,@RequestParam(name = "eventState", required = false) String eventState
								,@RequestParam(name = "memberId", required = false) String memberId
								,@RequestParam(name = "eventTitle", required = false) String eventTitle
								,@RequestParam(name = "eventContent", required = false) String eventContent
								,@RequestParam(name = "updateTime", required = false) String updateTime
								,Event event) {
		boardService.eventModify(event);
		System.out.println("eventModify----------"+event);
		return "redirect:/admin/eventList";
	}
	
	/*이벤트 등록*/
	@GetMapping("/eventForm")
	public String eventForm(@RequestParam(name = "eventCode", required = false) String eventCode
							,Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		Member member = memberService.getMemberInfoById(sessionId);
		model.addAttribute("title", "이벤트 등록");
		model.addAttribute("titleName", "이벤트 등록");
		model.addAttribute("member", member);
		return "/admin/board/eventForm";
	}	
	@PostMapping("/eventForm")
	public String eventForm(Event event, HttpSession session
							,RedirectAttributes reAttr, @RequestParam MultipartFile[] boardImgFile, HttpServletRequest request) {
		System.out.println("------------------------이벤트 등록 처리-----------------------------");
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		String sessionId = (String)session.getAttribute("SID");
		
		if("localhost".equals(serverName)) {
			// server 가 localhost 일때 접근
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			System.out.println(System.getProperty("user.dir"));
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			//배포용 주소
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		String eventCode = boardService.eventForm(event, sessionId, boardImgFile, fileRealPath);
		reAttr.addAttribute("eventCode", eventCode);
		System.out.println("------------------------이벤트 등록 처리 끝-----------------------------");
		
		return "redirect:/admin/eventList";
	}
	
	/*이벤트 상세 조회*/
	@GetMapping("/eventDetail")
		public String eventDetail(@RequestParam(name = "eventCode", required = false) String eventCode
								, Model model) {
		Event event = boardService.eventDetail(eventCode);
		int readCount = boardService.eventreadCount(event);
		String mId = event.getMemberId();
		Member member = memberService.getMemberInfoById(mId);
		model.addAttribute("readCount", readCount);
		model.addAttribute("event", event);
		model.addAttribute("member", member);
		System.out.println("event MODEL"+event);
		return "/admin/board/eventDetail";
		}		

	/*이벤트 목록 조회*/
	@GetMapping("/eventList")
	public String eventList(Model model) {
		List<Event> eventList = boardService.getEventList();
		List<Event> runEventList = boardService.runEventList();
		List<Event> endEventList = boardService.endEventList();	
		int runeventListCount = boardMapper.getRunEventListCount();
		int endeventListCount = boardMapper.getEndEventListCount();
		model.addAttribute("eventList", eventList);
		model.addAttribute("runEventList", runEventList);
		model.addAttribute("endEventList", endEventList);
		model.addAttribute("runeventListCount", runeventListCount);
		model.addAttribute("endeventListCount", endeventListCount);
		return "/admin/board/eventList";
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
		return "/admin/board/noticeModify";
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
		return "/admin/board/noticeForm";
	}
	
	@PostMapping("/noticeForm")
	@ResponseBody
	public String noticeForm(Board board, HttpSession session 
							,RedirectAttributes reAttr, @RequestParam MultipartFile[] boardImgFile, HttpServletRequest request) {
		System.out.println("------------------------게시글 등록 처리-----------------------------");
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		String sessionId = (String)session.getAttribute("SID");
		
		if("localhost".equals(serverName)) {
			// server 가 localhost 일때 접근
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			System.out.println(System.getProperty("user.dir"));
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			//배포용 주소
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		String boardIdx = boardService.noticeForm(board, sessionId, boardImgFile, fileRealPath);
		reAttr.addAttribute("boardIdx", boardIdx);
		System.out.println("------------------------게시글 등록 처리 끝-----------------------------");
		
		return "/admin/noticeList";
	}
	
	/*공지사항 상세 조회*/
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(name = "boardMenuCode", required = false) String boardMenuCode
								,@RequestParam(name = "boardIdx", required = false) String boardIdx
								, Model model) {
		Board board = boardService.getBoardDetailByCode(boardMenuCode, boardIdx);
		int readCount = boardService.readCount(board);
		model.addAttribute("readCount", readCount);
		System.out.println("---------board-noticedetail---------"+board);
		String mId = board.getMemberId();
		Member member = memberService.getMemberInfoById(mId);
		model.addAttribute("member", member);
		model.addAttribute("board", board);
		System.out.println("--------member-noticedetail--------" + member);
	
		
		return "/admin/board/noticeDetail";
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
		
		log.info("getNoticeList : {}", resultMap.get("getNoticeList"));
		return "/admin/board/noticeList";
	}
	
}