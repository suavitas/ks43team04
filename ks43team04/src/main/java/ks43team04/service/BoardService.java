package ks43team04.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.As;
import ks43team04.dto.Board;
import ks43team04.dto.Event;
import ks43team04.dto.LaundryList;
import ks43team04.dto.Review;
import ks43team04.mapper.AsMapper;
import ks43team04.mapper.BoardMapper;
import ks43team04.mapper.LaundryMapper;

@Service
@Transactional

public class BoardService {

	private final BoardMapper boardMapper;
	private final AsMapper asMapper;
	private final LaundryMapper laundryMapper;

	public BoardService(BoardMapper boardMapper, AsMapper asMapper,LaundryMapper laundryMapper) {
		this.boardMapper = boardMapper;
		this.asMapper = asMapper;
		this.laundryMapper = laundryMapper;
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
	
	/*AS 삭제
	public int asDel(As as) {
		int result = asMapper.asDel(as);
		return result;
	}*/
	
	/*AS 수정*/
	public int asModify(As as) {
		int result = asMapper.asModify(as);
		return result;
	}
	
	/*AS 완료
	public int asEnd(As as) {
		int result = asMapper.asEnd(as);
		return result;
	}*/
	
	/*AS 접수*/
	public int asReceipt(As as) {
		int result = asMapper.asReceipt(as);
		return result;
	}
	
	/*AS 신고*/
	public int asForm(As as, String sessionId) {

		as.setMemberId(sessionId);

		int result = asMapper.asForm(as);
		return result;
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
	public int eventForm(Event event, String sessionId) {
		event.setMemberId(sessionId);
		int result = boardMapper.eventForm(event);
		return result;
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
	public int qnaComment(Board board, String sessionId) {
		board.setMemberId(sessionId);
		int result = boardMapper.qnaComment(board);
		return result;
	}
	
	/*문의사항 작성*/
	public int qnaWrite(Board board, String sessionId) {
		board.setMemberId(sessionId);
		int result = boardMapper.qnaWrite(board);
		return result;
	}
	
	/*(USER)공지사항 작성*/
	public int noticeWrite(Board board, String sessionId) {
		board.setMemberId(sessionId);
		int result = boardMapper.noticeWrite(board);
		return result;
	}
	
	/*(ADMIN)공지사항 작성*/
	public int noticeForm(Board board, String sessionId) {
		board.setMemberId(sessionId);
		int result = boardMapper.noticeForm(board);
		return result;
	}
	

	/*분류별 게시물 내용 조회*/
	public Board getBoardDetailByCode(String boardMenuCode, int boardIdx) {
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

	/* 공지사항 목록 조회 */
	public List<Board> getNoticeList() {
		List<Board> noticeList = boardMapper.getNoticeList();
		return noticeList;
	}

}
