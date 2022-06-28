package ks43team04.dto;

public class Board {
	private String boardMenuCode;
	private String boardIdx;
	private String memeberId;
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
	public String getMemeberId() {
		return memeberId;
	}
	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
	
		builder.append(", boardMenuCode=");
		builder.append(boardMenuCode);
		builder.append(", boardIdx=");
		builder.append(boardIdx);
		builder.append(", memeberId=");
		builder.append(memeberId);
		builder.append(", boardGroupNo=");
		builder.append(boardGroupNo);
		builder.append(", boardOrderNo=");
		builder.append(boardOrderNo);
		builder.append(", boardReadCount=");
		builder.append(boardReadCount);
		builder.append(", boardTitle=");
		builder.append(boardTitle);
		builder.append(", boardContent=");
		builder.append(boardContent);
		builder.append(", boardSecret=");
		builder.append(boardSecret);
		builder.append(", boardAddFile=");
		builder.append(boardAddFile);
		builder.append(", boardAddFileName=");
		builder.append(boardAddFileName);
		builder.append(", boardAddFileChangeName=");
		builder.append(boardAddFileChangeName);
		builder.append(", boardAddFileVol=");
		builder.append(boardAddFileVol);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", commentState=");
		builder.append(commentState);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
