package ks43team04.dto;

public class LoginHistory {

	private String mLoginCode;
	private String memberId;
	private String mLoginTime;
	private String mLogoutTime;
	private String IpAddress;
	private String Os;
	private String browser;
	private String adminLevelCode;
	
	public String getmLoginCode() {
		return mLoginCode;
	}
	public void setmLoginCode(String mLoginCode) {
		this.mLoginCode = mLoginCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getmLoginTime() {
		return mLoginTime;
	}
	public void setmLoginTime(String mLoginTime) {
		this.mLoginTime = mLoginTime;
	}
	public String getmLogoutTime() {
		return mLogoutTime;
	}
	public void setmLogoutTime(String mLogoutTime) {
		this.mLogoutTime = mLogoutTime;
	}
	public String getIpAddress() {
		return IpAddress;
	}
	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}
	public String getOs() {
		return Os;
	}
	public void setOs(String os) {
		Os = os;
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
		builder.append("LoginHistory [mLoginCode=");
		builder.append(mLoginCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", mLoginTime=");
		builder.append(mLoginTime);
		builder.append(", mLogoutTime=");
		builder.append(mLogoutTime);
		builder.append(", IpAddress=");
		builder.append(IpAddress);
		builder.append(", Os=");
		builder.append(Os);
		builder.append(", browser=");
		builder.append(browser);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
