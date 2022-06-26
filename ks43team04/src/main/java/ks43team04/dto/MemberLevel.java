package ks43team04.dto;

public class MemberLevel {
	private String levelCode;
	private String levelName;
	private String adminLevelCode;
	private String registTime;

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
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

	@Override
	public String toString() {
		return "Level [levelCode=" + levelCode + ", levelName=" + levelName + ", adminLevelCode=" + adminLevelCode
				+ ", registTime=" + registTime + "]";
	}

}
