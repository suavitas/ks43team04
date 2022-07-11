package ks43team04.dto;

public class UserLevel {
	
	private String userLevelCalCode;
	private String levelCode;
	private String rangeStart;
	private String rangeEnd;
	private String savePointPercent;
	private String adminLevelCode;
	private String registTime;
	private String updateTime;
	
	
	public String getUserLevelCalCode() {
		return userLevelCalCode;
	}
	public void setUserLevelCalCode(String userLevelCalCode) {
		this.userLevelCalCode = userLevelCalCode;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getRangeStart() {
		return rangeStart;
	}
	public void setRangeStart(String rangeStart) {
		this.rangeStart = rangeStart;
	}
	public String getRangeEnd() {
		return rangeEnd;
	}
	public void setRangeEnd(String rangeEnd) {
		this.rangeEnd = rangeEnd;
	}
	public String getSavePointPercent() {
		return savePointPercent;
	}
	public void setSavePointPercent(String savePointPercent) {
		this.savePointPercent = savePointPercent;
	}
	public String getAdminLevelCode() {
		return adminLevelCode;
	}
	public void setAdminLevelCode(String adminLevelCode) {
		this.adminLevelCode = adminLevelCode;
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
		StringBuilder builder = new StringBuilder();
		builder.append("userLevel [userLevelCalCode=");
		builder.append(userLevelCalCode);
		builder.append(", levelCode=");
		builder.append(levelCode);
		builder.append(", rangeStart=");
		builder.append(rangeStart);
		builder.append(", rangeEnd=");
		builder.append(rangeEnd);
		builder.append(", savePointPercent=");
		builder.append(savePointPercent);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append("]");
		return builder.toString();
	}	
}
