package ks43team04.dto;

import java.util.List;

public class Delivery {
	private String deliveryCode;
	private String laundryCode;
	private String requestCode;
	private String deliveryAddr;
	private String userCode;
	private String billCode;
	private String deliveryPlanDate;
	private String deliveryFinishTime;
	private String contractRiderCode;
	
	private List<LaundryList> laundryList;
	private List<User> user;
	private List<Member> memberList;
	
	public String getDeliveryCode() {
		return deliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
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
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getDeliveryPlanDate() {
		return deliveryPlanDate;
	}
	public void setDeliveryPlanDate(String deliveryPlanDate) {
		this.deliveryPlanDate = deliveryPlanDate;
	}
	public String getDeliveryFinishTime() {
		return deliveryFinishTime;
	}
	public void setDeliveryFinishTime(String deliveryFinishTime) {
		this.deliveryFinishTime = deliveryFinishTime;
	}
	public String getContractRiderCode() {
		return contractRiderCode;
	}
	public void setContractRiderCode(String contractRiderCode) {
		this.contractRiderCode = contractRiderCode;
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
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Delivery [deliveryCode=");
		builder.append(deliveryCode);
		builder.append(", laundryCode=");
		builder.append(laundryCode);
		builder.append(", requestCode=");
		builder.append(requestCode);
		builder.append(", deliveryAddr=");
		builder.append(deliveryAddr);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", billCode=");
		builder.append(billCode);
		builder.append(", deliveryPlanDate=");
		builder.append(deliveryPlanDate);
		builder.append(", deliveryFinishTime=");
		builder.append(deliveryFinishTime);
		builder.append(", contractRiderCode=");
		builder.append(contractRiderCode);
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
