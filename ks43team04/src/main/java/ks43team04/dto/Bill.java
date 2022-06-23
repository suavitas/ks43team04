package ks43team04.dto;

public class Bill {
	private String billCode;
	private String orderNumGroupcode;
	private String totalPrice;
	private String userCode;
	private String payUsePoint;
	private String payMethod;
	private String payOkDate;
	private String refundCode;
	private String afterUsePointPay;
	private String addPay;
	private String deliveryPay;
	private String totalPayGroupcode;

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getOrderNumGroupcode() {
		return orderNumGroupcode;
	}

	public void setOrderNumGroupcode(String orderNumGroupcode) {
		this.orderNumGroupcode = orderNumGroupcode;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPayUsePoint() {
		return payUsePoint;
	}

	public void setPayUsePoint(String payUsePoint) {
		this.payUsePoint = payUsePoint;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getPayOkDate() {
		return payOkDate;
	}

	public void setPayOkDate(String payOkDate) {
		this.payOkDate = payOkDate;
	}

	public String getRefundCode() {
		return refundCode;
	}

	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
	}

	public String getAfterUsePointPay() {
		return afterUsePointPay;
	}

	public void setAfterUsePointPay(String afterUsePointPay) {
		this.afterUsePointPay = afterUsePointPay;
	}

	public String getAddPay() {
		return addPay;
	}

	public void setAddPay(String addPay) {
		this.addPay = addPay;
	}

	public String getDeliveryPay() {
		return deliveryPay;
	}

	public void setDeliveryPay(String deliveryPay) {
		this.deliveryPay = deliveryPay;
	}

	public String getTotalPayGroupcode() {
		return totalPayGroupcode;
	}

	public void setTotalPayGroupcode(String totalPayGroupcode) {
		this.totalPayGroupcode = totalPayGroupcode;
	}

	@Override
	public String toString() {
		return "Bill [billCode=" + billCode + ", orderNumGroupcode=" + orderNumGroupcode + ", totalPrice=" + totalPrice
				+ ", userCode=" + userCode + ", payUsePoint=" + payUsePoint + ", payMethod=" + payMethod
				+ ", payOkDate=" + payOkDate + ", refundCode=" + refundCode + ", afterUsePointPay=" + afterUsePointPay
				+ ", addPay=" + addPay + ", deliveryPay=" + deliveryPay + ", totalPayGroupcode=" + totalPayGroupcode
				+ "]";
	}

}
