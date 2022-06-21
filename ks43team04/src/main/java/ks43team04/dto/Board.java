package ks43team04.dto;

public class Board {
	private String boardCode;
	private String boardMenuCode;
	private String memeberId;
	private String boardParentNo;
	private String boardReadCount;
	private String boardTitle;
	private String boardContent;
	private String boardSecret;
	private String boardAddFile;
	private String boardAddFileName;
	private String boardAddFileVol;
	private String registTime;
	private String updateTime;
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
	@Override
	public String toString() {
		return "Board [boardCode=" + boardCode + ", boardMenuCode=" + boardMenuCode + ", memeberId=" + memeberId
				+ ", boardParentNo=" + boardParentNo + ", boardReadCount=" + boardReadCount + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardSecret=" + boardSecret + ", boardAddFile="
				+ boardAddFile + ", boardAddFileName=" + boardAddFileName + ", boardAddFileVol=" + boardAddFileVol
				+ ", registTime=" + registTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
