package ks43team04.dto;

public class User {
	private String userCode;
	private String mId;
	private String userLevelChangeCode;
	private String pointUpdate;
	private String adminLevelCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getUserLevelChangeCode() {
		return userLevelChangeCode;
	}

	public void setUserLevelChangeCode(String userLevelChangeCode) {
		this.userLevelChangeCode = userLevelChangeCode;
	}

	public String getPointUpdate() {
		return pointUpdate;
	}

	public void setPointUpdate(String pointUpdate) {
		this.pointUpdate = pointUpdate;
	}

	public String getAdminLevelCode() {
		return adminLevelCode;
	}

	public void setAdminLevelCode(String adminLevelCode) {
		this.adminLevelCode = adminLevelCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userCode=");
		builder.append(userCode);
		builder.append(", mId=");
		builder.append(mId);
		builder.append(", userLevelChangeCode=");
		builder.append(userLevelChangeCode);
		builder.append(", pointUpdate=");
		builder.append(pointUpdate);
		builder.append(", adminLevelCode=");
		builder.append(adminLevelCode);
		builder.append("]");
		return builder.toString();
	}

}
