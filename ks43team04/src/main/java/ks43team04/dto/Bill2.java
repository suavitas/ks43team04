package ks43team04.dto;

public class Bill2 {
	private String billCode;
	private String memberId;
	private String goodsName;
	private String totalPrice;
	private String laundryName;
	private String refund;
	private String registTime;
	private String request;
	private String addPoint;
	
	
	public String getRequest() {
		return request;
	}

	public String getAddPoint() {
		return addPoint;
	}

	public void setAddPoint(String addPoint) {
		this.addPoint = addPoint;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getGoodsName() {
		return goodsName;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public String getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getLaundryName() {
		return laundryName;
	}


	public void setLaundryName(String laundryName) {
		this.laundryName = laundryName;
	}


	public String getRefund() {
		return refund;
	}


	public void setRefund(String refund) {
		this.refund = refund;
	}


	public String getRegistTime() {
		return registTime;
	}


	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}


	@Override
	public String toString() {
		return "Bill2 [billCode=" + billCode + ", memberId=" + memberId + ", goodsName=" + goodsName + ", totalPrice="
				+ totalPrice + ", laundryName=" + laundryName + ", refund=" + refund + ", registTime=" + registTime
				+ ", request=" + request + ", addPoint=" + addPoint + "]";
	}
	
	
}
