package ks43team04.dto;

public class MuinMachine {
	private String muinMachineCode;
	private String laundryCode;
	private String muinSpecCode;
	private String machineNumber;
	private String machineState;
	private String adminLevelCode;
	private String registTime;

	public String getMuinMachineCode() {
		return muinMachineCode;
	}

	public void setMuinMachineCode(String muinMachineCode) {
		this.muinMachineCode = muinMachineCode;
	}

	public String getLaundryCode() {
		return laundryCode;
	}

	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}

	public String getMuinSpecCode() {
		return muinSpecCode;
	}

	public void setMuinSpecCode(String muinSpecCode) {
		this.muinSpecCode = muinSpecCode;
	}

	public String getMachineNumber() {
		return machineNumber;
	}

	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}

	public String getMachineState() {
		return machineState;
	}

	public void setMachineState(String machineState) {
		this.machineState = machineState;
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
		return "muinMachine [muinMachineCode=" + muinMachineCode + ", laundryCode=" + laundryCode + ", muinSpecCode="
				+ muinSpecCode + ", machineNumber=" + machineNumber + ", machineState=" + machineState
				+ ", adminLevelCode=" + adminLevelCode + ", registTime=" + registTime + "]";
	}
}
