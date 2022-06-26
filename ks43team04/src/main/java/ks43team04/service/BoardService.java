package ks43team04.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.As;
import ks43team04.dto.Board;
import ks43team04.dto.Event;
import ks43team04.mapper.AsMapper;
import ks43team04.mapper.BoardMapper;

@Service
@Transactional

public class BoardService {

	private final BoardMapper boardMapper;
	private final AsMapper asMapper;

	public BoardService(BoardMapper boardMapper, AsMapper asMapper) {
		this.boardMapper = boardMapper;
		this.asMapper = asMapper;
	}
	/**
	 * AS 접수
	 */
	public int asForm(As as, String sessionId) {

		as.setLaundryCode(sessionId);

		int result = asMapper.asForm(as);
		return result;
	}
		
	
	
	/**
	 * AS 접수 상세조회
	 */
	public As getAsDetail(String asCode) {
		As as = asMapper.getAsDetail(asCode);
		return as;
	}
	
	/**
	 * AS 접수 목록
	 */
	public List<As> getAsList(){
		List<As> asList = asMapper.getAsList();
		return asList;
	}
	
	/*이벤트 상세 조회*/
	public Event eventDetail(String eventCode) {
		Event event = boardMapper.eventDetail(eventCode);
		return event;
	}
	
	/*이벤트 목록 조회*/
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
	
	/**
	 * 문의사항 작성
	 */
	public int qnaWrite(Board board, String sessionId) {
		board.setMemeberId(sessionId);
		int result = boardMapper.qnaWrite(board);
		return result;
	}
	
	/**
	 * 공지사항 입력
	 * 
	 * @param board
	 * @return
	 */
	public int noticeWrite(Board board, String sessionId) {

		board.setMemeberId(sessionId);

		int result = boardMapper.noticeWrite(board);
		return result;
	}
	
	public int noticeForm(Board board, String sessionId) {

		board.setMemeberId(sessionId);

		int result = boardMapper.noticeForm(board);
		return result;
	}
	

	/**
	 * 분류별 게시물 내용 조회
	 * 
	 * @param boardMenuCode
	 * @return Board
	 */
	public Board getBoardDetailByCode(String boardMenuCode, int totalNo) {
		Board board = boardMapper.getBoardDetailByCode(boardMenuCode, totalNo);
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
