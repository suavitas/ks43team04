package ks43team04.dto;

public class RefundWhy {
	private String refundWhyCode;
	private String refundWhyCate;
	private String adminLevelCode;
	private String registTime;
	
	public String getRefundWhyCode() {
		return refundWhyCode;
	}
	public void setRefundWhyCode(String refundWhyCode) {
		this.refundWhyCode = refundWhyCode;
	}
	public String getRefundWhyCate() {
		return refundWhyCate;
	}
	public void setRefundWhyCate(String refundWhyCate) {
		this.refundWhyCate = refundWhyCate;
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
		return "RefundWhy [refundWhyCode=" + refundWhyCode + ", refundWhyCate=" + refundWhyCate + ", adminLevelCode="
				+ adminLevelCode + ", registTime=" + registTime + "]";
	}
	
	
}
