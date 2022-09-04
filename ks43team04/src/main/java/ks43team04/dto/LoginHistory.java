package ks43team04.dto;

public class LoginHistory {

	private String memberLoginCode;
	private String memberId;
	private String memberLoginTime;
	private String memberLogoutTime;
	private String ipAddress;
	private String os;
	private String browser;
	private String adminLevelCode;
	
	
	public String getMemberLoginCode() {
		return memberLoginCode;
	}
	public void setMemberLoginCode(String memberLoginCode) {
		this.memberLoginCode = memberLoginCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberLoginTime() {
		return memberLoginTime;
	}
	public void setMemberLoginTime(String memberLoginTime) {
		this.memberLoginTime = memberLoginTime;
	}
	public String getMemberLogoutTime() {
		return memberLogoutTime;
	}
	public void setMemberLogoutTime(String memberLogoutTime) {
		this.memberLogoutTime = memberLogoutTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getAdminLevelCode() {
		return adminLevelCode;
	}
	public void setAdminLevelCode(String adminLevelCode) {
		this.adminLevelCode = adminLevelCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginHistory [memberLoginCode=");
		builder.append(memberLoginCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", memberLoginTime=");
		builder.append(memberLoginTime);
		builder.append(", memberLogoutTime=");
		builder.append(memberLogoutTime);
		builder.append(", ipAddress=");
		builder.append(ipAddress);
		builder.append(", os=");
		builder.append(os);
		builder.append(", browser=");
		builder.append(browser);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append("]");
		return builder.toString();
	}	
	
}
