package ks43team04.dto;

import java.util.List;
import java.util.Map;

public class Event {

	private String eventCode;
	private String memberId;
	private String eventNo;
	private String eventState;
	private String eventTitle;
	private String eventContent;
	private String eventAddFile;
	private String eventAddFileName;
	private String eventAddFileChangeName;
	private String eventAddFileVol;
	private String registTime;
	private String updateTime;
	private String eventReadCount;
	
	private List<Map<String, String>> 	relFileWithEvent;
	private List<BoardAttach> 				boardAttach;
	
	public List<Map<String, String>> getRelFileWithEvent() {
		return relFileWithEvent;
	}
	public void setRelFileWithEvent(List<Map<String, String>> relFileWithEvent) {
		this.relFileWithEvent = relFileWithEvent;
	}
	public List<BoardAttach> getBoardAttach() {
		return boardAttach;
	}
	public void setBoardAttach(List<BoardAttach> boardAttach) {
		this.boardAttach = boardAttach;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	public String getEventState() {
		return eventState;
	}
	public void setEventState(String eventState) {
		this.eventState = eventState;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public String getEventAddFile() {
		return eventAddFile;
	}
	public void setEventAddFile(String eventAddFile) {
		this.eventAddFile = eventAddFile;
	}
	public String getEventAddFileName() {
		return eventAddFileName;
	}
	public void setEventAddFileName(String eventAddFileName) {
		this.eventAddFileName = eventAddFileName;
	}
	public String getEventAddFileChangeName() {
		return eventAddFileChangeName;
	}
	public void setEventAddFileChangeName(String eventAddFileChangeName) {
		this.eventAddFileChangeName = eventAddFileChangeName;
	}
	public String getEventAddFileVol() {
		return eventAddFileVol;
	}
	public void setEventAddFileVol(String eventAddFileVol) {
		this.eventAddFileVol = eventAddFileVol;
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
	public String getEventReadCount() {
		return eventReadCount;
	}
	public void setEventReadCount(String eventReadCount) {
		this.eventReadCount = eventReadCount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [eventCode=");
		builder.append(eventCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", eventNo=");
		builder.append(eventNo);
		builder.append(", eventState=");
		builder.append(eventState);
		builder.append(", eventTitle=");
		builder.append(eventTitle);
		builder.append(", eventContent=");
		builder.append(eventContent);
		builder.append(", eventAddFile=");
		builder.append(eventAddFile);
		builder.append(", eventAddFileName=");
		builder.append(eventAddFileName);
		builder.append(", eventAddFileChangeName=");
		builder.append(eventAddFileChangeName);
		builder.append(", eventAddFileVol=");
		builder.append(eventAddFileVol);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", eventReadCount=");
		builder.append(eventReadCount);
		builder.append(", relFileWithEvent=");
		builder.append(relFileWithEvent);
		builder.append(", boardAttach=");
		builder.append(boardAttach);
		builder.append("]");
		return builder.toString();
	}
	
	
}
