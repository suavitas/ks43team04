package ks43team04.dto;

public class MemberLevel {
	private String levelCode;
	private String levelName;
	private String adminLevelCode;
	private String registTime;
	
	private UserLevel userLevel;
	
	private Member member;

	public UserLevel getUserLevel() {
		return userLevel;
	}
	
	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}
	
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
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
		StringBuilder builder = new StringBuilder();
		builder.append("MemberLevel [levelCode=");
		builder.append(levelCode);
		builder.append(", levelName=");
		builder.append(levelName);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", userLevel=");
		builder.append(userLevel);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}


}
