package ks43team04.dto;

public class Review {

	private String reviewCode;
	private String laundryCode;
	private String reviewContent;
	private String countingStar;
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getLaundryCode() {
		return laundryCode;
	}
	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewCode=");
		builder.append(reviewCode);
		builder.append(", laundryCode=");
		builder.append(laundryCode);
		builder.append(", reviewContent=");
		builder.append(reviewContent);
		builder.append(", countingStar=");
		builder.append(countingStar);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
