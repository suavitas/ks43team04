package ks43team04.dto;

import java.util.List;

public class As {
	private String asCode;
	private String laundryCode;
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

	public List<LaundryList> getLaundryList() {
		return LaundryList;
	}

	public void setLaundryList(List<LaundryList> laundryList) {
		LaundryList = laundryList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("As [asCode=");
		builder.append(asCode);
		builder.append(", laundryCode=");
		builder.append(laundryCode);
		builder.append(", asNumber=");
		builder.append(asNumber);
		builder.append(", asState=");
		builder.append(asState);
		builder.append(", asTitle=");
		builder.append(asTitle);
		builder.append(", asContent=");
		builder.append(asContent);
		builder.append(", asAddFile=");
		builder.append(asAddFile);
		builder.append(", asAddFileName=");
		builder.append(asAddFileName);
		builder.append(", asAddFileChangeName=");
		builder.append(asAddFileChangeName);
		builder.append(", asAddFileVol=");
		builder.append(asAddFileVol);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", LaundryList=");
		builder.append(LaundryList);
		builder.append("]");
		return builder.toString();
	}
	



	
}
