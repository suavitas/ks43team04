package ks43team04.dto;

public class MemberOut {
	private String mOutCode;
	private String memberId;
	private String mOutReason;
	private String mOutRequestTime;
	private String mOutOkayTime;
	private String mOutOkayState;
	private String mNotOkayReason;
	private String adminLevelCode;
	private String registTime;
	private String changeRound;
	private String finalState;
	
	
	public String getmOutCode() {
		return mOutCode;
	}
	public void setmOutCode(String mOutCode) {
		this.mOutCode = mOutCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getmOutReason() {
		return mOutReason;
	}
	public void setmOutReason(String mOutReason) {
		this.mOutReason = mOutReason;
	}
	public String getmOutRequestTime() {
		return mOutRequestTime;
	}
	public void setmOutRequestTime(String mOutRequestTime) {
		this.mOutRequestTime = mOutRequestTime;
	}
	public String getmOutOkayTime() {
		return mOutOkayTime;
	}
	public void setmOutOkayTime(String mOutOkayTime) {
		this.mOutOkayTime = mOutOkayTime;
	}
	public String getmOutOkayState() {
		return mOutOkayState;
	}
	public void setmOutOkayState(String mOutOkayState) {
		this.mOutOkayState = mOutOkayState;
	}
	public String getmNotOkayReason() {
		return mNotOkayReason;
	}
	public void setmNotOkayReason(String mNotOkayReason) {
		this.mNotOkayReason = mNotOkayReason;
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
		builder.append("MemberOut [mOutCode=");
		builder.append(mOutCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", mOutReason=");
		builder.append(mOutReason);
		builder.append(", mOutRequestTime=");
		builder.append(mOutRequestTime);
		builder.append(", mOutOkayTime=");
		builder.append(mOutOkayTime);
		builder.append(", mOutOkayState=");
		builder.append(mOutOkayState);
		builder.append(", mNotOkayReason=");
		builder.append(mNotOkayReason);
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
