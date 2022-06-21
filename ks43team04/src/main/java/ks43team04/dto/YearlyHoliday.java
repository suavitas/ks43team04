package ks43team04.dto;

public class YearlyHoliday {
	
	private String yearlyHolidayCode;
	private String yearlyHolidayDate;
	private String yearlyHolidayName;
	private String holidayCodeUse;
	private String adminLevelCode;
	private String registTime;
	public String getYearlyHolidayCode() {
		return yearlyHolidayCode;
	}
	public void setYearlyHolidayCode(String yearlyHolidayCode) {
		this.yearlyHolidayCode = yearlyHolidayCode;
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
	@Override
	public String toString() {
		return "YearlyHoliday [yearlyHolidayCode=" + yearlyHolidayCode + ", yearlyHolidayDate=" + yearlyHolidayDate
				+ ", yearlyHolidayName=" + yearlyHolidayName + ", holidayCodeUse=" + holidayCodeUse
				+ ", adminLevelCode=" + adminLevelCode + ", registTime=" + registTime + "]";
	}
	
	
	
}