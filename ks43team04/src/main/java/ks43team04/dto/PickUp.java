package ks43team04.dto;

import java.util.List;

public class PickUp {
	private String ilbanPickupCode;
	private String userCode;
	private String laundryCode;
	private String requestCode;
	private String pickupWantDate;
	private String pickupFinishTime;
	private String contractRriderCode;

	private List<LaundryList> laundryList;
	private List<User> user;
	private List<Member> memberList;

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public List<LaundryList> getLaundryList() {
		return laundryList;
	}

	public void setLaundryList(List<LaundryList> laundryList) {
		this.laundryList = laundryList;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public String getIlbanPickupCode() {
		return ilbanPickupCode;
	}

	public void setIlbanPickupCode(String ilbanPickupCode) {
		this.ilbanPickupCode = ilbanPickupCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getLaundryCode() {
		return laundryCode;
	}

	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}

	public String getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	public String getPickupWantDate() {
		return pickupWantDate;
	}

	public void setPickupWantDate(String pickupWantDate) {
		this.pickupWantDate = pickupWantDate;
	}

	public String getPickupFinishTime() {
		return pickupFinishTime;
	}

	public void setPickupFinishTime(String pickupFinishTime) {
		this.pickupFinishTime = pickupFinishTime;
	}

	public String getContractRriderCode() {
		return contractRriderCode;
	}

	public void setContractRriderCode(String contractRriderCode) {
		this.contractRriderCode = contractRriderCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PickUp [ilbanPickupCode=");
		builder.append(ilbanPickupCode);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", laundryCode=");
		builder.append(laundryCode);
		builder.append(", requestCode=");
		builder.append(requestCode);
		builder.append(", pickupWantDate=");
		builder.append(pickupWantDate);
		builder.append(", pickupFinishTime=");
		builder.append(pickupFinishTime);
		builder.append(", contractRriderCode=");
		builder.append(contractRriderCode);
		builder.append(", laundryList=");
		builder.append(laundryList);
		builder.append(", user=");
		builder.append(user);
		builder.append(", memberList=");
		builder.append(memberList);
		builder.append("]");
		return builder.toString();
	}

}
