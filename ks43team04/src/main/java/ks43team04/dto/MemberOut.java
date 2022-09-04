package ks43team04.dto;

public class MemberOut {
	private String memberOutCode;
	private String memberId;
	private String memberOutReason;
	private String memberOutRequestTime;
	private String memberOutOkayTime;
	private String memberOutOkayState;
	private String memberNotOkayReason;
	private String adminLevelCode;
	private String registTime;
	private String changeRound;
	private String finalState;
	
	
	public String getMemberOutCode() {
		return memberOutCode;
	}
	public void setMemberOutCode(String memberOutCode) {
		this.memberOutCode = memberOutCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberOutReason() {
		return memberOutReason;
	}
	public void setMemberOutReason(String memberOutReason) {
		this.memberOutReason = memberOutReason;
	}
	public String getMemberOutRequestTime() {
		return memberOutRequestTime;
	}
	public void setMemberOutRequestTime(String memberOutRequestTime) {
		this.memberOutRequestTime = memberOutRequestTime;
	}
	public String getMemberOutOkayTime() {
		return memberOutOkayTime;
	}
	public void setMemberOutOkayTime(String memberOutOkayTime) {
		this.memberOutOkayTime = memberOutOkayTime;
	}
	public String getMemberOutOkayState() {
		return memberOutOkayState;
	}
	public void setMemberOutOkayState(String memberOutOkayState) {
		this.memberOutOkayState = memberOutOkayState;
	}
	public String getMemberNotOkayReason() {
		return memberNotOkayReason;
	}
	public void setMemberNotOkayReason(String memberNotOkayReason) {
		this.memberNotOkayReason = memberNotOkayReason;
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
	public String getChangeRound() {
		return changeRound;
	}
	public void setChangeRound(String changeRound) {
		this.changeRound = changeRound;
	}
	public String getFinalState() {
		return finalState;
	}
	public void setFinalState(String finalState) {
		this.finalState = finalState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberOut [memberOutCode=");
		builder.append(memberOutCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", memberOutReason=");
		builder.append(memberOutReason);
		builder.append(", memberOutRequestTime=");
		builder.append(memberOutRequestTime);
		builder.append(", memberOutOkayTime=");
		builder.append(memberOutOkayTime);
		builder.append(", memberOutOkayState=");
		builder.append(memberOutOkayState);
		builder.append(", memberNotOkayReason=");
		builder.append(memberNotOkayReason);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", changeRound=");
		builder.append(changeRound);
		builder.append(", finalState=");
		builder.append(finalState);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
