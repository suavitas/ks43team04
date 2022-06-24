package ks43team04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Board;
import ks43team04.dto.Review;

@Mapper
public interface BoardMapper {
	
	// 리뷰 조회
	public List<Review> getReviewList();

	// 공지사항 글 수정
	public int noticeModify(Board board);

	// 공지사항 글 작성
	public int noticeWrite(Board board);

	// 분류별 게시물 조회
	public Board getBoardDetailByCode(String boardMenuCode, int boardParentNo);

	// 문의사항(서비스 불만족) 답변 목록 조회
	public List<Board> getAnsComplainList();

	// 문의사항(서비스 불만족) 목록 조회
	public List<Board> getQnaComplainList();

	// 문의사항(결제 포인트) 목록 조회
	public List<Board> getQnaPayList();

	// 문의사항(수거 배송) 목록 조회
	public List<Board> getQnaPickupList();

	// 문의사항(서비스 이용) 목록 조회
	public List<Board> getQnaServiceList();

	// 공지사항 목록 조회
	public List<Board> getNoticeList();
}