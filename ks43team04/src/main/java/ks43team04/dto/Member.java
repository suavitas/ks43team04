package ks43team04.dto;

public class Member {
	private String memberId;
	private String levelCode;
	private String memberPw;
	private String memberPwQnACode;
	private String memberName;
	private String memberBirth;
	private String memberPostNum;
	private String memberAddr;
	private String memberDetailAddr;
	private String memberPhone;
	private String memberGender;
	private String memberOutCode;
	private String memberEmail;
	private String memberRegDate;
	private String adminLevelCode;
	private String registTime;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberPwQnACode() {
		return memberPwQnACode;
	}

	public void setMemberPwQnACode(String memberPwQnACode) {
		this.memberPwQnACode = memberPwQnACode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPostNum() {
		return memberPostNum;
	}

	public void setMemberPostNum(String memberPostNum) {
		this.memberPostNum = memberPostNum;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberDetailAddr() {
		return memberDetailAddr;
	}

	public void setMemberDetailAddr(String memberDetailAddr) {
		this.memberDetailAddr = memberDetailAddr;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberOutCode() {
		return memberOutCode;
	}

	public void setMemberOutCode(String memberOutCode) {
		this.memberOutCode = memberOutCode;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberRegDate() {
		return memberRegDate;
	}

	public void setMemberRegDate(String memberRegDate) {
		this.memberRegDate = memberRegDate;
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
		builder.append("Member [memberId=");
		builder.append(memberId);
		builder.append(", levelCode=");
		builder.append(levelCode);
		builder.append(", memberPw=");
		builder.append(memberPw);
		builder.append(", memberPwQnACode=");
		builder.append(memberPwQnACode);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberBirth=");
		builder.append(memberBirth);
		builder.append(", memberPostNum=");
		builder.append(memberPostNum);
		builder.append(", memberAddr=");
		builder.append(memberAddr);
		builder.append(", memberDetailAddr=");
		builder.append(memberDetailAddr);
		builder.append(", memberPhone=");
		builder.append(memberPhone);
		builder.append(", memberGender=");
		builder.append(memberGender);
		builder.append(", memberOutCode=");
		builder.append(memberOutCode);
		builder.append(", memberEmail=");
		builder.append(memberEmail);
		builder.append(", memberRegDate=");
		builder.append(memberRegDate);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append("]");
		return builder.toString();
	}

}
