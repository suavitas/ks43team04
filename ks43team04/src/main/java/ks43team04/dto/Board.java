package ks43team04.dto;

public class Board {
	private String boardCode;
	private String boardMenuCode;
	private String totalNo;
	private String memeberId;
	private String boardParentNo;
	private String boardChildNo;
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
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardMenuCode() {
		return boardMenuCode;
	}
	public void setBoardMenuCode(String boardMenuCode) {
		this.boardMenuCode = boardMenuCode;
	}
	public String getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(String totalNo) {
		this.totalNo = totalNo;
	}
	public String getMemeberId() {
		return memeberId;
	}
	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
	}
	public String getBoardParentNo() {
		return boardParentNo;
	}
	public void setBoardParentNo(String boardParentNo) {
		this.boardParentNo = boardParentNo;
	}
	public String getBoardChildNo() {
		return boardChildNo;
	}
	public void setBoardChildNo(String boardChildNo) {
		this.boardChildNo = boardChildNo;
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
	public void setComment_state(String commentState) {
		this.commentState = commentState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [boardCode=");
		builder.append(boardCode);
		builder.append(", boardMenuCode=");
		builder.append(boardMenuCode);
		builder.append(", totalNo=");
		builder.append(totalNo);
		builder.append(", memeberId=");
		builder.append(memeberId);
		builder.append(", boardParentNo=");
		builder.append(boardParentNo);
		builder.append(", boardChildNo=");
		builder.append(boardChildNo);
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
