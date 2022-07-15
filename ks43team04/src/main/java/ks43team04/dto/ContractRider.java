package ks43team04.dto;

public class ContractRider {
	private String headContractRiderCode;
	private String headContractAdmin;
	private String headRiderConpanyName;
	private String headRiderPhone;
	private String headRiderArea;
	private String headRiderContractDate;
	public String getHeadContractRiderCode() {
		return headContractRiderCode;
	}
	public void setHeadContractRiderCode(String headContractRiderCode) {
		this.headContractRiderCode = headContractRiderCode;
	}
	public String getHeadContractAdmin() {
		return headContractAdmin;
	}
	public void setHeadContractAdmin(String headContractAdmin) {
		this.headContractAdmin = headContractAdmin;
	}
	public String getHeadRiderConpanyName() {
		return headRiderConpanyName;
	}
	public void setHeadRiderConpanyName(String headRiderConpanyName) {
		this.headRiderConpanyName = headRiderConpanyName;
	}
	public String getHeadRiderPhone() {
		return headRiderPhone;
	}
	public void setHeadRiderPhone(String headRiderPhone) {
		this.headRiderPhone = headRiderPhone;
	}
	public String getHeadRiderArea() {
		return headRiderArea;
	}
	public void setHeadRiderArea(String headRiderArea) {
		this.headRiderArea = headRiderArea;
	}
	public String getHeadRiderContractDate() {
		return headRiderContractDate;
	}
	public void setHeadRiderContractDate(String headRiderContractDate) {
		this.headRiderContractDate = headRiderContractDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContractRider [headContractRiderCode=");
		builder.append(headContractRiderCode);
		builder.append(", headContractAdmin=");
		builder.append(headContractAdmin);
		builder.append(", headRiderConpanyName=");
		builder.append(headRiderConpanyName);
		builder.append(", headRiderPhone=");
		builder.append(headRiderPhone);
		builder.append(", headRiderArea=");
		builder.append(headRiderArea);
		builder.append(", headRiderContractDate=");
		builder.append(headRiderContractDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
