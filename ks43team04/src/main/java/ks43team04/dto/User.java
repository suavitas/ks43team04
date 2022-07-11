package ks43team04.dto;

import java.util.List;

public class User {
	private String userCode;
	private String mId;
	private String userLevelChangeCode;
	private String pointUpdate;
	private String adminLevelCode;	
	
	private List<Order> orderList;
	private List<Bill> billList;
	private List<IlbanGprice> ilbanGpriceList;
	
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

	public List<IlbanGprice> getIlbanGpriceList() {
		return ilbanGpriceList;
	}

	public void setIlbanGpriceList(List<IlbanGprice> ilbanGpriceList) {
		this.ilbanGpriceList = ilbanGpriceList;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getUserLevelChangeCode() {
		return userLevelChangeCode;
	}

	public void setUserLevelChangeCode(String userLevelChangeCode) {
		this.userLevelChangeCode = userLevelChangeCode;
	}

	public String getPointUpdate() {
		return pointUpdate;
	}

	public void setPointUpdate(String pointUpdate) {
		this.pointUpdate = pointUpdate;
	}

	public String getAdminLevelCode() {
		return adminLevelCode;
	}

	public void setAdminLevelCode(String adminLevelCode) {
		this.adminLevelCode = adminLevelCode;
	}

	@Override
	public String toString() {
		return "User [userCode=" + userCode + ", mId=" + mId + ", userLevelChangeCode=" + userLevelChangeCode
				+ ", pointUpdate=" + pointUpdate + ", adminLevelCode=" + adminLevelCode + ", orderList=" + orderList
				+ ", billList=" + billList + ", ilbanGpriceList=" + ilbanGpriceList + "]";
	}

}
