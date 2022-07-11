
package ks43team04.dto;

import java.util.List;

public class LaundryList {

	private String laundryCode;
	private String memberId;
	private String levelCode;
	private String laundryName;
	private String laundryState;
	private String laundryPostNum;
	private String laundryAddr;
	private String laundryDetailAddr;
	private String laundryTel;
	private String laundryLicenseImg;
	private String laundryImg;
	private String skillLicence;
	private String businessNumber;
	private String adminLevelCode;
	private String registTime;

	private List<HolidayList> holidayList;
	
	private List<IlbanGprice> ilbanGpriceList;
	private List<Order> orderList;
	private List<Bill> billList;	
	private List<MonthBill> monthbillList;	
	
	public List<MonthBill> getMonthbillList() {
		return monthbillList;
	}

	public void setMonthbillList(List<MonthBill> monthbillList) {
		this.monthbillList = monthbillList;
	}

	public List<IlbanGprice> getIlbanGpriceList() {
		return ilbanGpriceList;
	}

	public void setIlbanGpriceList(List<IlbanGprice> ilbanGpriceList) {
		this.ilbanGpriceList = ilbanGpriceList;
	}

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

	public String getLaundryCode() {
		return laundryCode;
	}

	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getLaundryName() {
		return laundryName;
	}

	public void setLaundryName(String laundryName) {
		this.laundryName = laundryName;
	}

	public String getLaundryState() {
		return laundryState;
	}

	public void setLaundryState(String laundryState) {
		this.laundryState = laundryState;
	}

	public String getLaundryPostNum() {
		return laundryPostNum;
	}

	public void setLaundryPostNum(String laundryPostNum) {
		this.laundryPostNum = laundryPostNum;
	}

	public String getLaundryAddr() {
		return laundryAddr;
	}

	public void setLaundryAddr(String laundryAddr) {
		this.laundryAddr = laundryAddr;
	}

	public String getLaundryDetailAddr() {
		return laundryDetailAddr;
	}

	public void setLaundryDetailAddr(String laundryDetailAddr) {
		this.laundryDetailAddr = laundryDetailAddr;
	}

	public String getLaundryTel() {
		return laundryTel;
	}

	public void setLaundryTel(String laundryTel) {
		this.laundryTel = laundryTel;
	}

	public String getLaundryLicenseImg() {
		return laundryLicenseImg;
	}

	public void setLaundryLicenseImg(String laundryLicenseImg) {
		this.laundryLicenseImg = laundryLicenseImg;
	}

	public String getLaundryImg() {
		return laundryImg;
	}

	public void setLaundryImg(String laundryImg) {
		this.laundryImg = laundryImg;
	}

	public String getSkillLicence() {
		return skillLicence;
	}

	public void setSkillLicence(String skillLicence) {
		this.skillLicence = skillLicence;
	}

	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
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

	public List<HolidayList> getHolidayList() {
		return holidayList;
	}

	public void setHolidayList(List<HolidayList> holidayList) {
		this.holidayList = holidayList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LaundryList [laundryCode=");
		builder.append(laundryCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", levelCode=");
		builder.append(levelCode);
		builder.append(", laundryName=");
		builder.append(laundryName);
		builder.append(", laundryState=");
		builder.append(laundryState);
		builder.append(", laundryPostNum=");
		builder.append(laundryPostNum);
		builder.append(", laundryAddr=");
		builder.append(laundryAddr);
		builder.append(", laundryDetailAddr=");
		builder.append(laundryDetailAddr);
		builder.append(", laundryTel=");
		builder.append(laundryTel);
		builder.append(", laundryLicenseImg=");
		builder.append(laundryLicenseImg);
		builder.append(", laundryImg=");
		builder.append(laundryImg);
		builder.append(", skillLicence=");
		builder.append(skillLicence);
		builder.append(", businessNumber=");
		builder.append(businessNumber);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", holidayList=");
		builder.append(holidayList);
		builder.append(", ilbanGpriceList=");
		builder.append(ilbanGpriceList);
		builder.append(", orderList=");
		builder.append(orderList);
		builder.append(", billList=");
		builder.append(billList);
		builder.append(", monthbillList=");
		builder.append(monthbillList);
		builder.append("]");
		return builder.toString();
	}

	
}