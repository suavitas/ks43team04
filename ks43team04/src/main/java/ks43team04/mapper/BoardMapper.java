package ks43team04.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks43team04.dto.Board;
import ks43team04.dto.Event;
import ks43team04.dto.Review;

@Mapper
public interface BoardMapper {
	
	//내가 쓴 글 목록 총 row 수
	public int myWritingListCount(String memberId);
	
	//내가 쓴 글 조회
	public List<Board> myWritingList(String memberId);
	
	//문의사항 답변 수정
	public int qnaCommentModify(Board board);
	
	//문의사항 글 삭제
	public int qnaRemove(Board board);
	
	//문의사항 글 수정
	public int qnaModify(Board board);
	
	//조회수 올리기
	public int readCount(Board board);
	public int eventreadCount(Event event);
	
	//이벤트(목록)상태변경 - 종료
	//public int eventEnd(Event event);
	
	//이벤트 글 삭제
	public int eventRemove(Event event);
	
	//이벤트 글 수정
	public int eventModify(Event event);
	
	//이벤트 등록
	public int eventForm(Event event);
	
	//이벤트 상세 조회
	public Event eventDetail(String eventCode);
	
	//이벤트 목록 총 row 수
	public int getRunEventListCount();
	public int getEndEventListCount();
	
	//이벤트 목록 조회
	public List<Event> getEventList();
	public List<Event> getEventListForUser();
	public List<Event> runEventList();
	public List<Event> endEventList();
	
	//리뷰 조회
	public List<Review> getReviewList();
	
	//리뷰 삭제
	public int rvDel(String reviewCode);
	
	//공지사항 글 삭제
	public int noticeRemove(Board board);

	//공지사항 글 수정
	public int noticeModify(Board board);

	//공지사항 작성
	//public int noticeWrite(Board board);
	public int noticeForm(Board board);
	
	//문의사항 답변 작성 시 상태변경
	public int commentComplete(Board board);
	
	//문의사항 답변 작성
	public int qnaComment(Board board);
	
	//문의사항 작성
	public int qnaWrite(Board board);
		
	//분류별 게시물 조회
	public Board getBoardDetailByCode(String boardMenuCode, String boardIdx);

	//문의사항(서비스 불만족) 목록 조회
	public List<Board> getQnaComplainList();

	//문의사항(결제 포인트) 목록 조회
	public List<Board> getQnaPayList();

	//문의사항(수거 배송) 목록 조회
	public List<Board> getQnaPickupList();

	//문의사항(서비스 이용) 목록 조회
	public List<Board> getQnaServiceList();
	
	//문의사항 목록 총 row 수
	public int getQnaServiceListCount();
	public int getQnaPickupListCount();
	public int getQnaPayListCount();
	public int getQnaComplainListCount();
	
	//공지사항 목록 조회(페이징)
	public List<Board> getNoticeList(Map<String, Object> paramMap);
	
	//공지사항 목록 총 row 수
	public int getNoticeListCount();
	
	//공지사항 목록 조회
	public List<Board> getNoticeList();

	
}