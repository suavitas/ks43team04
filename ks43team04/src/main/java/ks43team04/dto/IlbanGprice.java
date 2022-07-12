package ks43team04.dto;

public class IlbanGprice {
	private String ilbanGPriceCode;
	private String laundryCode;
	private String ilbanSkillCode;
	private String gName;
	private String gPrice;
	private String registTime;
	private String gPriceUseState;
	public String getIlbanGPriceCode() {
		return ilbanGPriceCode;
	}
	public void setIlbanGPriceCode(String ilbanGPriceCode) {
		this.ilbanGPriceCode = ilbanGPriceCode;
	}
	public String getLaundryCode() {
		return laundryCode;
	}
	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}
	public String getIlbanSkillCode() {
		return ilbanSkillCode;
	}
	public void setIlbanSkillCode(String ilbanSkillCode) {
		this.ilbanSkillCode = ilbanSkillCode;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgPrice() {
		return gPrice;
	}
	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public String getgPriceUseState() {
		return gPriceUseState;
	}
	public void setgPriceUseState(String gPriceUseState) {
		this.gPriceUseState = gPriceUseState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IlbanGprice [ilbanGPriceCode=");
		builder.append(ilbanGPriceCode);
		builder.append(", laundryCode=");
		builder.append(laundryCode);
		builder.append(", ilbanSkillCode=");
		builder.append(ilbanSkillCode);
		builder.append(", gName=");
		builder.append(gName);
		builder.append(", gPrice=");
		builder.append(gPrice);
		builder.append(", registTime=");
		builder.append(registTime);
		builder.append(", gPriceUseState=");
		builder.append(gPriceUseState);
		builder.append("]");
		return builder.toString();
	}

	
}
