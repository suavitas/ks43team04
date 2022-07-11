package ks43team04.dto;

import java.util.List;

public class LaundryInfoSebu {
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
	private String reviewCode;
	private String reviewContent;
	private String reveiwNum;
	private String countingStar;
	private List<IlbanGprice> ilbanGpriceList;
	
	

	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public List<IlbanGprice> getIlbanGpriceList() {
		return ilbanGpriceList;
	}
	public void setIlbanGpriceList(List<IlbanGprice> ilbanGpriceList) {
		this.ilbanGpriceList = ilbanGpriceList;
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
	public String getReveiwNum() {
		return reveiwNum;
	}
	public void setReveiwNum(String reveiwNum) {
		this.reveiwNum = reveiwNum;
	}	
	@Override
	public String toString() {
		return "LaundryInfoSebu [laundryCode=" + laundryCode + ", memberId=" + memberId + ", levelCode=" + levelCode
				+ ", laundryName=" + laundryName + ", laundryState=" + laundryState + ", laundryPostNum="
				+ laundryPostNum + ", laundryAddr=" + laundryAddr + ", laundryDetailAddr=" + laundryDetailAddr
				+ ", laundryTel=" + laundryTel + ", laundryLicenseImg=" + laundryLicenseImg + ", laundryImg="
				+ laundryImg + ", skillLicence=" + skillLicence + ", businessNumber=" + businessNumber
				+ ", adminLevelCode=" + adminLevelCode + ", registTime=" + registTime + ", reviewCode=" + reviewCode
				+ ", reviewContent=" + reviewContent + ", reveiwNum=" + reveiwNum + ", countingStar=" + countingStar
				+ ", ilbanGpriceList=" + ilbanGpriceList + "]";
	}
	public String getCountingStar() {
		return countingStar;
	}
	public void setCountingStar(String countingStar) {
		this.countingStar = countingStar;
	}
	
}