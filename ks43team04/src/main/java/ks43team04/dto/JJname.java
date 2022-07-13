package ks43team04.dto;


public class JJname {
	private String laundryCode;
	private String laundryName;
	private String memberName;
	private String memberPhone;
	public String getLaundryCode() {
		return laundryCode;
	}
	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}
	public String getLaundryName() {
		return laundryName;
	}
	public void setLaundryName(String laundryName) {
		this.laundryName = laundryName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	@Override
	public String toString() {
		return "JJname [laundryCode=" + laundryCode + ", laundryName=" + laundryName + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + "]";
	}
	
	

}
