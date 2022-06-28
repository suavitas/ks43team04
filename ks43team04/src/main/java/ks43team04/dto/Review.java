package ks43team04.dto;

import java.util.List;

public class Review {

	private String reviewCode;
	private String reveiwNum;
	private String laundryCode;
	private String memberId;
	private String reviewContent;
	private String countingStar;
	private String registTime;
	
	private List<LaundryList> LaundryList;
	
	
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getReveiwNum() {
		return reveiwNum;
	}
	public void setReveiwNum(String reveiwNum) {
		this.reveiwNum = reveiwNum;
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
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getCountingStar() {
		return countingStar;
	}
	public void setCountingStar(String countingStar) {
		this.countingStar = countingStar;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public List<LaundryList> getLaundryList() {
		return LaundryList;
	}

	public void setLaundryList(List<LaundryList> laundryList) {
		LaundryList = laundryList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewCode=");
		builder.append(reviewCode);
		builder.append(", reveiwNum=");
		builder.append(reveiwNum);
		builder.append(", laundryCode=");
		builder.append(laundryCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", reviewContent=");
		builder.append(reviewContent);
		builder.append(", countingStar=");
		builder.append(countingStar);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", LaundryList=");
		builder.append(LaundryList);
		builder.append("]");
		return builder.toString();
	}
	
	
}
