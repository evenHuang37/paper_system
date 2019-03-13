package model.vo;

public class Articles 
{
	private int articleID;
	private String articletitle;
	private String stuID;
	private String articlehref;
	private String handindate;
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getArticletitle() {
		return articletitle;
	}
	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getArticlehref() {
		return articlehref;
	}
	public void setArticlehref(String articlehref) {
		this.articlehref = articlehref;
	}
	public String getHandindate() {
		return handindate;
	}
	public void setHandindate(String handindate) {
		this.handindate = handindate;
	}
}
