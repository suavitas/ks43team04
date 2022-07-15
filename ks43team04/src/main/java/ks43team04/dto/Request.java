package ks43team04.dto;

public class Request {
	private String RequestCode;
	private String RequestCate;
	public String getRequestCode() {
		return RequestCode;
	}
	public void setRequestCode(String requestCode) {
		RequestCode = requestCode;
	}
	public String getRequestCate() {
		return RequestCate;
	}
	public void setRequestCate(String requestCate) {
		RequestCate = requestCate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Request [RequestCode=");
		builder.append(RequestCode);
		builder.append(", RequestCate=");
		builder.append(RequestCate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
