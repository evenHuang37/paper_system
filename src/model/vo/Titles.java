package model.vo;

public class Titles {
	private int titleID;
	private String titleName;
	private String facultyID;
	private String titleAbstract;
	public int getTitleID() {
		return titleID;
	}
	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getFacultyID() {
		return facultyID;
	}
	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}
	public String getTitleAbstract() {
		return titleAbstract;
	}
	public void setTitleAbstract(String titleAbstract) {
		this.titleAbstract = titleAbstract;
	}
}

