package ks43team04.dto;

public class Order {
	private String orderCode;
	private String ilbanGPriceCode;
	private String userCode;
	private String orderNumGroupCode;
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getIlbanGPriceCode() {
		return ilbanGPriceCode;
	}
	public void setIlbanGPriceCode(String ilbanGPriceCode) {
		this.ilbanGPriceCode = ilbanGPriceCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getOrderNumGroupCode() {
		return orderNumGroupCode;
	}
	public void setOrderNumGroupCode(String orderNumGroupCode) {
		this.orderNumGroupCode = orderNumGroupCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderCode=");
		builder.append(orderCode);
		builder.append(", ilbanGPriceCode=");
		builder.append(ilbanGPriceCode);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", orderNumGroupCode=");
		builder.append(orderNumGroupCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
