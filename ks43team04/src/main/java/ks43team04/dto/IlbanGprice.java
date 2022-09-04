package ks43team04.dto;

public class IlbanGprice {
	private String ilbanGPriceCode;
	private String laundryCode;
	private String ilbanSkillCode;
	private String gName;
	private String gPrice;
	private String registTime;
	private String gPriceUseState;
	/*goods -> g 로 변경해서 오류 발생. 아래 코드 추가해서 오류 제거*/
	private String ilbanGoodsPriceCode;
	private String goodsName;
	private String goodsPrice;
	private String goodsPriceUseState;
	
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsPriceUseState() {
		return goodsPriceUseState;
	}
	public void setGoodsPriceUseState(String goodsPriceUseState) {
		this.goodsPriceUseState = goodsPriceUseState;
	}
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
		return "IlbanGprice [ilbanGPriceCode=" + ilbanGPriceCode + ", laundryCode=" + laundryCode + ", ilbanSkillCode="
				+ ilbanSkillCode + ", gName=" + gName + ", gPrice=" + gPrice + ", registTime=" + registTime
				+ ", gPriceUseState=" + gPriceUseState + ", ilbanGoodsPriceCode=" + ilbanGoodsPriceCode + ", goodsName="
				+ goodsName + ", goodsPrice=" + goodsPrice + ", goodsPriceUseState=" + goodsPriceUseState + "]";
	}
	public String getIlbanGoodsPriceCode() {
		return ilbanGoodsPriceCode;
	}
	public void setIlbanGoodsPriceCode(String ilbanGoodsPriceCode) {
		this.ilbanGoodsPriceCode = ilbanGoodsPriceCode;
	}

	
}
