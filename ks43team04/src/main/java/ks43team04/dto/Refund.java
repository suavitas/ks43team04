package ks43team04.dto;

public class Refund {
	private String refundCode;
	private String billCode;
	private String refundStatus;
	private String refundWhyCode;
	private String registTime;
	private String adminLevelCode;
	
	private RefundWhy refundWhy;
	
	public RefundWhy getRefundWhy() {
		return refundWhy;
	}
	public void setRefundWhy(RefundWhy refundWhy) {
		this.refundWhy = refundWhy;
	}
	public String getRefundCode() {
		return refundCode;
	}
	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public String getRefundWhyCode() {
		return refundWhyCode;
	}
	public void setRefundWhyCode(String refundWhyCode) {
		this.refundWhyCode = refundWhyCode;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public String getAdminLevelCode() {
		return adminLevelCode;
	}
	public void setAdminLevelCode(String adminLevelCode) {
		this.adminLevelCode = adminLevelCode;
	}
	@Override
	public String toString() {
		return "Refund [refundCode=" + refundCode + ", billCode=" + billCode + ", refundStatus=" + refundStatus
				+ ", refundWhyCode=" + refundWhyCode + ", registTime=" + registTime + ", adminLevelCode="
				+ adminLevelCode + ", refundWhy=" + refundWhy + "]";
	}

	
}
