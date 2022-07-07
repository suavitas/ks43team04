package ks43team04.dto;

import java.util.List;

public class As {
	private String asCode;
	private String laundryCode;
	private String memberId;
	private String asNumber;
	private String asState;
	private String asTitle;
	private String asContent;
	private String asAddFile;
	private String asAddFileName;
	private String asAddFileChangeName;
	private String asAddFileVol;
	private String registTime;
	private String updateTime;
	private String visitTime;
	
	private List<LaundryList> LaundryList;

	public String getAsCode() {
		return asCode;
	}

	public void setAsCode(String asCode) {
		this.asCode = asCode;
	}

	public String getLaundryCode() {
		return laundryCode;
	}

	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAsNumber() {
		return asNumber;
	}

	public void setAsNumber(String asNumber) {
		this.asNumber = asNumber;
	}

	public String getAsState() {
		return asState;
	}

	public void setAsState(String asState) {
		this.asState = asState;
	}

	public String getAsTitle() {
		return asTitle;
	}

	public void setAsTitle(String asTitle) {
		this.asTitle = asTitle;
	}

	public String getAsContent() {
		return asContent;
	}

	public void setAsContent(String asContent) {
		this.asContent = asContent;
	}

	public String getAsAddFile() {
		return asAddFile;
	}

	public void setAsAddFile(String asAddFile) {
		this.asAddFile = asAddFile;
	}

	public String getAsAddFileName() {
		return asAddFileName;
	}

	public void setAsAddFileName(String asAddFileName) {
		this.asAddFileName = asAddFileName;
	}

	public String getAsAddFileChangeName() {
		return asAddFileChangeName;
	}

	public void setAsAddFileChangeName(String asAddFileChangeName) {
		this.asAddFileChangeName = asAddFileChangeName;
	}

	public String getAsAddFileVol() {
		return asAddFileVol;
	}

	public void setAsAddFileVol(String asAddFileVol) {
		this.asAddFileVol = asAddFileVol;
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

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public List<LaundryList> getLaundryList() {
		return LaundryList;
	}

	public void setLaundryList(List<LaundryList> laundryList) {
		LaundryList = laundryList;
	}

	@Override
	public String toString() {
		return "As [asCode=" + asCode + ", laundryCode=" + laundryCode + ", memberId=" + memberId + ", asNumber="
				+ asNumber + ", asState=" + asState + ", asTitle=" + asTitle + ", asContent=" + asContent
				+ ", asAddFile=" + asAddFile + ", asAddFileName=" + asAddFileName + ", asAddFileChangeName="
				+ asAddFileChangeName + ", asAddFileVol=" + asAddFileVol + ", registTime=" + registTime
				+ ", updateTime=" + updateTime + ", visitTime=" + visitTime + ", LaundryList=" + LaundryList + "]";
	}

	
	
	



	
}
