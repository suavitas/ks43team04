package ks43team04.dto;

public class IlbanGprice {
	private String ilbanGoodsPriceCode;
	private String laundryCode;
	private String ilbanSkillCode;
	private String goodsName;
	private String goodsPrice;
	private String registTime;
	private String goodsPriceUseState;

	public String getIlbanGoodsPriceCode() {
		return ilbanGoodsPriceCode;
	}

	public void setIlbanGoodsPriceCode(String ilbanGoodsPriceCode) {
		this.ilbanGoodsPriceCode = ilbanGoodsPriceCode;
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

	public String getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	public String getGoodsPriceUseState() {
		return goodsPriceUseState;
	}

	public void setGoodsPriceUseState(String goodsPriceUseState) {
		this.goodsPriceUseState = goodsPriceUseState;
	}

	@Override
	public String toString() {
		return "ilbanGprice [ilbanGoodsPriceCode=" + ilbanGoodsPriceCode + ", laundryCode=" + laundryCode
				+ ", ilbanSkillCode=" + ilbanSkillCode + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", registTime=" + registTime + ", goodsPriceUseState=" + goodsPriceUseState + "]";
	}

}
