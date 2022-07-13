package ks43team04.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ks43team04.common.FileUtils;
import ks43team04.dto.As;
import ks43team04.dto.Board;
import ks43team04.dto.Event;
import ks43team04.dto.LaundryList;
import ks43team04.dto.Review;
import ks43team04.mapper.AsMapper;
import ks43team04.mapper.BoardMapper;
import ks43team04.mapper.LaundryMapper;
import ks43team04.mapper.FileMapper;

@Service
@Transactional

public class BoardService {

	private final BoardMapper boardMapper;
	private final AsMapper asMapper;
	private final LaundryMapper laundryMapper;
	private final FileMapper fileMapper;
	
	private static final Logger log = LoggerFactory.getLogger(BoardService.class);

	public BoardService(BoardMapper boardMapper, AsMapper asMapper,LaundryMapper laundryMapper, FileMapper fileMapper) {
		this.boardMapper = boardMapper;
		this.asMapper = asMapper;
		this.laundryMapper = laundryMapper;
		this.fileMapper = fileMapper;
	}
	
	/*문의사항 답변 수정*/
	public int qnaCommentModify(Board board) {
		int result = boardMapper.qnaCommentModify(board);
		return result;
	}
	
	/*문의사항 삭제*/
	public int qnaRemove(Board board) {
		int result = boardMapper.qnaRemove(board);
		return result;
	}
	
	/*문의사항 수정*/
	public int qnaModify(Board board) {
		int result = boardMapper.qnaModify(board);
		return result;
	}
	
	/*이벤트 삭제*/
	public int eventRemove(Event event) {
		int result = boardMapper.eventRemove(event);
		return result;
	}
	
	/*이벤트 수정*/
	public int eventModify(Event event) {
		int result = boardMapper.eventModify(event);
		return result;
	}
	
	/*게시판(이벤트) 조회수*/
	public int eventreadCount(Event event) {
		int result = boardMapper.eventreadCount(event);
		return result;
	}
	
	/*게시판 조회수*/
	public int readCount(Board board) {
		int result = boardMapper.readCount(board);
		return result;
	}
	
	/*공지사항 삭제*/
	public int noticeRemove(Board board) {
		int result = boardMapper.noticeRemove(board);
		return result;
	}
	
	/*공지사항 수정*/
	public int noticeModify(Board board) {
		int result = boardMapper.noticeModify(board);
		return result;
	}
	
	/*멤버이름으로 세탁소조회*/
	public List<LaundryList> getMemberLaundryList(String memberId){
		List<LaundryList> getMemberLaundryList = laundryMapper.getMemberLaundryList(memberId);
		return getMemberLaundryList;
	}
	
	/*리뷰 목록 조회*/
	public List<Review> getReviewList(){
		List<Review> reviewList = boardMapper.getReviewList();
		return reviewList;
	}
	
	/*AS 삭제*/
	public int asDel(As as) {
		int result = asMapper.asDel(as);
		return result;
	}
	
	/*AS 수정*/
	public int asModify(As as) {
		int result = asMapper.asModify(as);
		return result;
	}
	
	/*AS 방문(예정)일 변경*/
	public int asVisitChange(As as) {
		int result = asMapper.asVisitChange(as);
		return result;
	}
	
	/*AS 완료*/
	public int asEnd(As as) {
		int result = asMapper.asEnd(as);
		return result;
	}
	
	/*AS 접수*/
	public int asReceipt(As as) {
		int result = asMapper.asReceipt(as);
		return result;
	}
	
	/*AS 신고*/
	public String asForm(As as, String sessionId, MultipartFile[] boardImgFile, String fileRealPath) {
		System.out.println("------------------------as 등록 서비스-----------------------------");
		/*  1. 파일 업로드
		 	2. 파일 업로드 성공시 파일 DB 인서트
		 	3. 게시글 인서트
 			4. 결과값 리턴	*/
		
		as.setMemberId(sessionId);
		
		/*여기부터*/
		boolean fileCheck = true;
		
		for (MultipartFile multipartFile : boardImgFile){
			if(!multipartFile.isEmpty()) {
				fileCheck = false;
			}
		}
		
		if (!fileCheck) {
			
		
		//파일 업로드 위한 객체 생성 
		FileUtils fu = new FileUtils(boardImgFile, as.getMemberId(), fileRealPath);
		List<Map<String, String>> dtoFileList = fu.parseFileInfo();
				
		// t_file 테이블에 삽입
		System.out.println(dtoFileList + "<<<dtoFileList입니다.");
		fileMapper.uploadFile(dtoFileList);
				
		asMapper.asForm(as);
		String asCode = as.getAsCode();
		
		// 릴레이션 테이블에 삽입
		 List<Map<String, String>> relationFileList = new ArrayList<>();
		 for(Map<String, String> m : dtoFileList) {
		 m.put("asCode", asCode);
		 relationFileList.add(m);
		 		}
		 System.out.println(relationFileList + "<<<relationFileList(as)입니다.");
	 		fileMapper.uploadRelationFileWithAs(relationFileList);
	     	
			System.out.println("-----------------------as 접수 서비스 끝------------------------------");
			return asCode;
		}else {
			
			int result = asMapper.asForm(as);
			return Integer.toString(result);
		}
	}	
	
	
	
	
	/*AS 상세 조회*/
	public As getAsDetail(String asCode) {
		As as = asMapper.getAsDetail(asCode);
		return as;
	}
	
	/*회원별 AS 목록*/
	public List<As> asListById(String memberId){
		List<As> asListById = asMapper.asListById(memberId);
		return asListById;
	}
	
	/*AS 전체 목록*/
	public List<As> getAsList(){
		List<As> asList = asMapper.getAsList();
		return asList;
	}
	
	/*AS 대기 목록*/
	public List<As> readyAsList(){
		List<As> asList = asMapper.readyAsList();
		return asList;
	}
	
	/*AS 접수 목록*/
	public List<As> startAsList(){
		List<As> asList = asMapper.startAsList();
		return asList;
	}
	
	/*AS 완료 목록*/
	public List<As> endAsList(){
		List<As> asList = asMapper.endAsList();
		return asList;
	}
	
	/*이벤트 등록*/
	public String eventForm(Event event, String sessionId, MultipartFile[] boardImgFile, String fileRealPath) {
		System.out.println("------------------------이벤트 등록 서비스-----------------------------");
		/*  1. 파일 업로드
		 	2. 파일 업로드 성공시 파일 DB 인서트
		 	3. 게시글 인서트
 			4. 결과값 리턴	*/
		
		event.setMemberId(sessionId);
		
		/*여기부터*/
		boolean fileCheck = true;
		
		for (MultipartFile multipartFile : boardImgFile){
			if(!multipartFile.isEmpty()) {
				fileCheck = false;
			}
		}
		
		if (!fileCheck) {
			
		
		//파일 업로드 위한 객체 생성 
		FileUtils fu = new FileUtils(boardImgFile, event.getMemberId(), fileRealPath);
		List<Map<String, String>> dtoFileList = fu.parseFileInfo();
				
		// t_file 테이블에 삽입
		System.out.println(dtoFileList + "<<<dtoFileList입니다.");
		fileMapper.uploadFile(dtoFileList);
				
		boardMapper.eventForm(event);
		String eventCode = event.getEventCode();
		
		// 릴레이션 테이블에 삽입
		 List<Map<String, String>> relationFileList = new ArrayList<>();
		 for(Map<String, String> m : dtoFileList) {
		 m.put("eventCode", eventCode);
		 relationFileList.add(m);
		 		}
		 System.out.println(relationFileList + "<<<relationFileList(Event)입니다.");
	 		fileMapper.uploadRelationFileWithEvent(relationFileList);
	     	
			System.out.println("-----------------------이벤트 등록 서비스 끝------------------------------");
			return eventCode;
		}else {
			
			int result = boardMapper.eventForm(event);
			return Integer.toString(result);
		}
	}	

		
	
	/*이벤트 상세 조회*/
	public Event eventDetail(String eventCode) {
		Event event = boardMapper.eventDetail(eventCode);
		return event;
	}
	
	/*전체 이벤트 목록 조회*/
	public List<Event> getEventList(){
		List<Event> eventList = boardMapper.getEventList();
		return eventList;
	}
	
	/*(USER)전체 이벤트 목록 조회*/
	public List<Event> getEventListForUser(){
		List<Event> eventList = boardMapper.getEventListForUser();
		return eventList;
	}
	
	/*진행 중인 이벤트 목록 조회*/
	public List<Event> runEventList(){
		List<Event> runEventList = boardMapper.runEventList();
		return runEventList;
	}
	
	/*종료 이벤트 목록 조회*/
	public List<Event> endEventList(){
		List<Event> endEventList = boardMapper.endEventList();
		return endEventList;
	}
	
	/*문의사항 상태 변경*/
	public int commentComplete(Board board) {
		int result = boardMapper.commentComplete(board);
		return result;
	}
	
	/*문의사항 답변 작성*/
	public String qnaComment(Board board, String sessionId, MultipartFile[] boardImgFile, String fileRealPath) {
		System.out.println("------------------------문의사항 등록 서비스-----------------------------");
		/*  1. 파일 업로드
		 	2. 파일 업로드 성공시 파일 DB 인서트
		 	3. 게시글 인서트
 			4. 결과값 리턴	*/
		
		board.setMemberId(sessionId);
		
		/*여기부터*/
		boolean fileCheck = true;
		
		for (MultipartFile multipartFile : boardImgFile){
			if(!multipartFile.isEmpty()) {
				fileCheck = false;
			}
		}
		
		if (!fileCheck) {
			
		
		//파일 업로드 위한 객체 생성 
		FileUtils fu = new FileUtils(boardImgFile, board.getMemberId(), fileRealPath);
		List<Map<String, String>> dtoFileList = fu.parseFileInfo();
				
		// t_file 테이블에 삽입
		System.out.println(dtoFileList + "<<<dtoFileList입니다.");
		fileMapper.uploadFile(dtoFileList);
				
		boardMapper.qnaComment(board);
		String boardIdx = board.getBoardIdx();
		
		// 릴레이션 테이블에 삽입
		 List<Map<String, String>> relationFileList = new ArrayList<>();
		 for(Map<String, String> m : dtoFileList) {
		 m.put("boardIdx", boardIdx);
		 relationFileList.add(m);
		 		}
		 System.out.println(relationFileList + "<<<relationFileList입니다.");
	 		fileMapper.uploadRelationFileWithBoard(relationFileList);
	     	
			System.out.println("-----------------------게시글 등록 서비스 끝------------------------------");
			return boardIdx;
		}else {
			
			int result = boardMapper.qnaComment(board);
			return Integer.toString(result);
		}
	}	
	
	/*문의사항 작성*/
	public String qnaWrite(Board board, String sessionId, MultipartFile[] boardImgFile, String fileRealPath) {
			System.out.println("------------------------문의사항 등록 서비스-----------------------------");
			/*  1. 파일 업로드
			 	2. 파일 업로드 성공시 파일 DB 인서트
			 	3. 게시글 인서트
	 			4. 결과값 리턴	*/
			
			board.setMemberId(sessionId);
			
			/*여기부터*/
			boolean fileCheck = true;
			
			for (MultipartFile multipartFile : boardImgFile){
				if(!multipartFile.isEmpty()) {
					fileCheck = false;
				}
			}
			
			if (!fileCheck) {
				
			
			//파일 업로드 위한 객체 생성 
			FileUtils fu = new FileUtils(boardImgFile, board.getMemberId(), fileRealPath);
			List<Map<String, String>> dtoFileList = fu.parseFileInfo();
					
			// t_file 테이블에 삽입
			System.out.println(dtoFileList + "<<<dtoFileList입니다.");
			fileMapper.uploadFile(dtoFileList);
					
			boardMapper.qnaWrite(board);
			String boardIdx = board.getBoardIdx();
			
			// 릴레이션 테이블에 삽입
			 List<Map<String, String>> relationFileList = new ArrayList<>();
			 for(Map<String, String> m : dtoFileList) {
			 m.put("boardIdx", boardIdx);
			 relationFileList.add(m);
			 		}
			 System.out.println(relationFileList + "<<<relationFileList입니다.");
		 		fileMapper.uploadRelationFileWithBoard(relationFileList);
		     	
				System.out.println("-----------------------게시글 등록 서비스 끝------------------------------");
				return boardIdx;
			}else {
				
				int result = boardMapper.qnaWrite(board);
				return Integer.toString(result);
			}
		}	
	
	
	
	/*(ADMIN)공지사항 작성*/
	public String noticeForm(Board board, String sessionId, MultipartFile[] boardImgFile, String fileRealPath) {
		System.out.println("------------------------공지사항 등록 서비스-----------------------------");
		/*  1. 파일 업로드
		 	2. 파일 업로드 성공시 파일 DB 인서트
		 	3. 게시글 인서트
 			4. 결과값 리턴	*/
		
		board.setMemberId(sessionId);
		
		/*여기부터*/
		boolean fileCheck = true;
		
		for (MultipartFile multipartFile : boardImgFile){
			if(!multipartFile.isEmpty()) {
				fileCheck = false;
			}
		}
		
		if (!fileCheck) {
			
		
		//파일 업로드 위한 객체 생성 
		FileUtils fu = new FileUtils(boardImgFile, board.getMemberId(), fileRealPath);
		List<Map<String, String>> dtoFileList = fu.parseFileInfo();
				
		// t_file 테이블에 삽입
		System.out.println(dtoFileList + "<<<dtoFileList입니다.");
		fileMapper.uploadFile(dtoFileList);
				
		boardMapper.noticeForm(board);
		String boardIdx = board.getBoardIdx();
		
		// 릴레이션 테이블에 삽입
		 List<Map<String, String>> relationFileList = new ArrayList<>();
		 for(Map<String, String> m : dtoFileList) {
		 m.put("boardIdx", boardIdx);
		 relationFileList.add(m);
		 		}
		 System.out.println(relationFileList + "<<<relationFileList입니다.");
	 		fileMapper.uploadRelationFileWithBoard(relationFileList);
	     	
			System.out.println("-----------------------게시글 등록 서비스 끝------------------------------");
			return boardIdx;
		}else {
			
			int result = boardMapper.noticeForm(board);
			return Integer.toString(result);
		}
	}	

	/*분류별 게시물 내용 조회*/
	public Board getBoardDetailByCode(String boardMenuCode, String boardIdx) {
		Board board = boardMapper.getBoardDetailByCode(boardMenuCode, boardIdx);
		return board;
	}

	/* 문의사항(서비스 불만족) 목록 조회 */
	public List<Board> getQnaComplainList() {
		List<Board> qnaComplainList = boardMapper.getQnaComplainList();
		return qnaComplainList;
	}

	/* 문의사항(결제 포인트) 목록 조회 */
	public List<Board> getQnaPayList() {
		List<Board> qnaPayList = boardMapper.getQnaPayList();
		return qnaPayList;
	}

	/* 문의사항(수거 배송) 목록 조회 */
	public List<Board> getQnaPickupList() {
		List<Board> qnaPickupList = boardMapper.getQnaPickupList();
		return qnaPickupList;
	}
	
	/* 문의사항(서비스 이용) 목록 조회 */
	public List<Board> getQnaServiceList() {
		List<Board> qnaServiceList = boardMapper.getQnaServiceList();
		return qnaServiceList;
	}

	/* 공지사항 목록 조회(페이징 처리) */
	public Map<String, Object> getNoticeList(int currentPage){
		int rowPerPage = 10;
		int startPageNum = 1;
		int endPageNum = 3;
		
		double rowCount = boardMapper.getNoticeListCount();
		int lastPage = (int)Math.ceil(rowCount/rowPerPage);
		int startRow = (currentPage - 1) * rowPerPage;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		List<Board> getNoticeList = boardMapper.getNoticeList(paramMap);
		
		System.out.println("getNoticeList : {}" + getNoticeList);
		
		if (currentPage > 6) {
			startPageNum = currentPage - 5;
			endPageNum = currentPage + 4; // 자신 포함 / last-21페이지 픽스. 21-4 = 17부터는 움직이지않겠다. 17커런트로왔을때

			if (endPageNum >= lastPage) { // 17이상부터 클릭시 숫자가 늘어나지않고 고정되는 모습
				startPageNum = lastPage - 9; // 라스트페이지해당 21-9 = 12부터 고정시키겠다.
				endPageNum = lastPage;
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lastPage", lastPage);
		resultMap.put("getNoticeList", getNoticeList);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		resultMap.put("rowCount", rowCount);
		
		return resultMap;
	}

	
	/* 공지사항 목록 조회 
	public List<Board> getNoticeList() {
		List<Board> noticeList = boardMapper.getNoticeList();
		return noticeList;
	}
*/
}
