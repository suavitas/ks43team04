package ks43team04.dto;

public class HolidayList {

	private String holidayCode;
	private String laundryCode;
	private String yearlyHolidayDate;
	private String yearlyHolidayName;
	private String holidayCodeUse;

	public String getHolidayCode() {
		return holidayCode;
	}

	public void setHolidayCode(String holidayCode) {
		this.holidayCode = holidayCode;
	}

	public String getLaundryCode() {
		return laundryCode;
	}

	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}

	public String getYearlyHolidayDate() {
		return yearlyHolidayDate;
	}

	public void setYearlyHolidayDate(String yearlyHolidayDate) {
		this.yearlyHolidayDate = yearlyHolidayDate;
	}

	public String getYearlyHolidayName() {
		return yearlyHolidayName;
	}

	public void setYearlyHolidayName(String yearlyHolidayName) {
		this.yearlyHolidayName = yearlyHolidayName;
	}

	public String getHolidayCodeUse() {
		return holidayCodeUse;
	}

	public void setHolidayCodeUse(String holidayCodeUse) {
		this.holidayCodeUse = holidayCodeUse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HolidayList [holidayCode=");
		builder.append(holidayCode);
		builder.append(", laundryCode=");
		builder.append(laundryCode);
		builder.append(", yearlyHolidayDate=");
		builder.append(yearlyHolidayDate);
		builder.append(", yearlyHolidayName=");
		builder.append(yearlyHolidayName);
		builder.append(", holidayCodeUse=");
		builder.append(holidayCodeUse);
		builder.append("]");
		return builder.toString();
	}

}