package ks43team04.dto;


public class LaundryInfoSebu {
	private String levelCode;
	@Override
	public String toString() {
		return "LaundryInfoList [levelCode=" + levelCode + ", laundryName=" + laundryName + ", laundryState="
				+ laundryState + ", laundryAddr=" + laundryAddr + ", laundryTel=" + laundryTel + "]";
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
	public String getLaundryAddr() {
		return laundryAddr;
	}
	public void setLaundryAddr(String laundryAddr) {
		this.laundryAddr = laundryAddr;
	}
	public String getLaundryTel() {
		return laundryTel;
	}
	public void setLaundryTel(String laundryTel) {
		this.laundryTel = laundryTel;
	}
	private String laundryName;
	private String laundryState;
	private String laundryAddr;
	private String laundryTel;
}
