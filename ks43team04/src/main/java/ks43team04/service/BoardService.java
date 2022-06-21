package ks43team04.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team04.dto.Board;
import ks43team04.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	private final BoardMapper boardMapper;
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	/**
	 * 분류별 게시물 내용 조회
	 * @param boardCode
	 * @return Board
	 */
	public Board getBoardDetailByCode(String boardCode) {
		Board board = boardMapper.getBoardDetailByCode(boardCode);
		return board;
	}
	
	/*문의사항(서비스 불만족) 목록 조회*/
	public List<Board> getQnaComplainList(){
		List<Board> qnaComplainList = boardMapper.getQnaComplainList();
		return qnaComplainList;
	}
	
	/*문의사항(결제 포인트) 목록 조회*/
	public List<Board> getQnaPayList(){
		List<Board> qnaPayList = boardMapper.getQnaPayList();
		return qnaPayList;
	}
	
	/*문의사항(수거 배송) 목록 조회*/
	public List<Board> getQnaPickupList() {
		List<Board> qnaPickupList = boardMapper.getQnaPickupList();
		return qnaPickupList;
	}
	
	
	/*문의사항(서비스 이용) 목록 조회*/
	public List<Board> getQnaServiceList(){
		List<Board> qnaServiceList = boardMapper.getQnaServiceList();
		return qnaServiceList;
	}
	
	/*공지사항 목록 조회*/
	public List<Board> getNoticeList(){
		List<Board> noticeList = boardMapper.getNoticeList();
		return noticeList;
	}

	
}
