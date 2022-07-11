package ks43team04.dto;

import java.util.List;
import java.util.Map;



public class Board {
	private String boardMenuCode;
	private String boardIdx;
	private String memberId;
	private String boardGroupNo;
	private String boardOrderNo;
	private String boardReadCount;
	private String boardTitle;
	private String boardContent;
	private String boardSecret;
	private String boardAddFile;
	private String boardAddFileName;
	private String boardAddFileChangeName;
	private String boardAddFileVol;
	private String registTime;
	private String updateTime;
	private String commentState;
	
	private List<Map<String, String>> 	relFileWithBoard;
	private List<BoardAttach> 				boardAttach;
	
	public String getBoardMenuCode() {
		return boardMenuCode;
	}
	public void setBoardMenuCode(String boardMenuCode) {
		this.boardMenuCode = boardMenuCode;
	}
	public String getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(String boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBoardGroupNo() {
		return boardGroupNo;
	}
	public void setBoardGroupNo(String boardGroupNo) {
		this.boardGroupNo = boardGroupNo;
	}
	public String getBoardOrderNo() {
		return boardOrderNo;
	}
	public void setBoardOrderNo(String boardOrderNo) {
		this.boardOrderNo = boardOrderNo;
	}
	public String getBoardReadCount() {
		return boardReadCount;
	}
	public void setBoardReadCount(String boardReadCount) {
		this.boardReadCount = boardReadCount;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardSecret() {
		return boardSecret;
	}
	public void setBoardSecret(String boardSecret) {
		this.boardSecret = boardSecret;
	}
	public String getBoardAddFile() {
		return boardAddFile;
	}
	public void setBoardAddFile(String boardAddFile) {
		this.boardAddFile = boardAddFile;
	}
	public String getBoardAddFileName() {
		return boardAddFileName;
	}
	public void setBoardAddFileName(String boardAddFileName) {
		this.boardAddFileName = boardAddFileName;
	}
	public String getBoardAddFileChangeName() {
		return boardAddFileChangeName;
	}
	public void setBoardAddFileChangeName(String boardAddFileChangeName) {
		this.boardAddFileChangeName = boardAddFileChangeName;
	}
	public String getBoardAddFileVol() {
		return boardAddFileVol;
	}
	public void setBoardAddFileVol(String boardAddFileVol) {
		this.boardAddFileVol = boardAddFileVol;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getCommentState() {
		return commentState;
	}
	public void setCommentState(String commentState) {
		this.commentState = commentState;
	}
	
	
	public List<Map<String, String>> getRelFileWithBoard() {
		return relFileWithBoard;
	}
	public void setRelFileWithBoard(List<Map<String, String>> relFileWithBoard) {
		this.relFileWithBoard = relFileWithBoard;
	}
	public List<BoardAttach> getBoardAttach() {
		return boardAttach;
	}
	public void setBoardAttach(List<BoardAttach> boardAttach) {
		this.boardAttach = boardAttach;
	}
	@Override
	public String toString() {
		return "Board [boardMenuCode=" + boardMenuCode + ", boardIdx=" + boardIdx + ", memberId=" + memberId
				+ ", boardGroupNo=" + boardGroupNo + ", boardOrderNo=" + boardOrderNo + ", boardReadCount="
				+ boardReadCount + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardSecret="
				+ boardSecret + ", boardAddFile=" + boardAddFile + ", boardAddFileName=" + boardAddFileName
				+ ", boardAddFileChangeName=" + boardAddFileChangeName + ", boardAddFileVol=" + boardAddFileVol
				+ ", registTime=" + registTime + ", updateTime=" + updateTime + ", commentState=" + commentState
				+ ", relFileWithBoard=" + relFileWithBoard + ", boardAttach=" + boardAttach + "]";
	}

	
	
	
}
