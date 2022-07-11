package ks43team04.dto;

public class IlbanSkill {
	private String ilbanSkillCode;
	private String skillCate;
	private String adminLevelCode;
	private String registTime;

	public String getIlbanSkillCode() {
		return ilbanSkillCode;
	}

	public void setIlbanSkillCode(String ilbanSkillCode) {
		this.ilbanSkillCode = ilbanSkillCode;
	}

	public String getSkillCate() {
		return skillCate;
	}

	public void setSkillCate(String skillCate) {
		this.skillCate = skillCate;
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
		return "IlbanSkill [ilbanSkillCode=" + ilbanSkillCode + ", skillCate=" + skillCate + ", adminLevelCode="
				+ adminLevelCode + ", registTime=" + registTime + "]";
	}

}