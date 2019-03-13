package model.vo;

public class ArticleStage {
	private int stageID;
	private String stageName;
	private String missionExplain;
	private String beginDate;
	private String endDate;
	private String facultyID;
	public int getStageID() {
		return stageID;
	}
	public void setStageID(int stageID) {
		this.stageID = stageID;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getMissionExplain() {
		return missionExplain;
	}
	public void setMissionExplain(String missionExplain) {
		this.missionExplain = missionExplain;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFacultyID() {
		return facultyID;
	}
	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}
}
