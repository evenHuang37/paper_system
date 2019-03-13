package model.action;

import model.dao.FacultiesDAO;
import model.daoFactory.ArticleStageDAOFactory;
import model.daoFactory.FacultiesDAOFactory;
import model.daoFactory.FacultyManagersDAOFactory;
import model.daoFactory.NoticeDAOFactory;
import model.daoFactory.ScoresDAOFactory;
import model.daoFactory.TitlesDAOFactory;
import model.vo.ArticleStage;
import model.vo.Faculties;
import model.vo.Facultymanagers;
import model.vo.Notice;
import model.vo.Scores;
import model.vo.Titles;
import model.vo.Tutors;

public class FamAction 
{
	Facultymanagers facultymanagers=null;
	
	public Faculties getFacultyInfo(String facultyID)
	{
		Faculties faculty=null;
		try {
			faculty=FacultiesDAOFactory.getInstance().findById(facultyID);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return faculty;
	}
	//大黄
	//获得院系教务管理人员个人信息
	public Facultymanagers getInfo(String managerID)
	{
		try {
			facultymanagers=FacultyManagersDAOFactory.getInstance().findById(managerID);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return facultymanagers;
	
	}
		
	//大黄
	//发布论文阶段信息
	public boolean submitArticleStage(String managerID,String stagename,String missionExplain,String beginDate,String endDate)
	{
		boolean flag=false;
		ArticleStage articelstage=new ArticleStage();
		try {
			facultymanagers=FacultyManagersDAOFactory.getInstance().findById(managerID);
			String facultyid=facultymanagers.getFacultyID();
			
		   articelstage.setStageName(stagename);
		   articelstage.setMissionExplain(missionExplain);
		   articelstage.setBeginDate(beginDate);
		   articelstage.setEndDate(endDate);
		   articelstage.setFacultyID(facultyid);
		   flag=ArticleStageDAOFactory.getInstance().doCreate(articelstage);
            
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return flag;
	}
	//大黄
	//发布选题
	public boolean submitTitles(int titleID,String titleName, String managerID,String titleAbstract)
	{
		
		Titles title=new Titles();
		boolean flag=false;
		try {
			facultymanagers=FacultyManagersDAOFactory.getInstance().findById(managerID);
			String facultyid=facultymanagers.getFacultyID();
			title.setFacultyID(facultyid);
			title.setTitleID(titleID);
			title.setTitleName(titleName);
			title.setTitleAbstract(titleAbstract);
			flag=TitlesDAOFactory.getInstance().doCreate(title);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return flag;
	}
	
		
	//42	
	//提交毕业生答辩成绩
		public boolean submitReplyscore(String stuID,double replyscore)
		{
			Scores score=null;
			boolean flag=false;
			  try {
				score=ScoresDAOFactory.getInstance().findById(stuID);
				if(score==null)
				{
					score=new Scores();
					score.setStuID(stuID);
					score.setReplyscore(replyscore);
					score.setTutorscore(0);
					score.setFinalscore(0);
					flag=ScoresDAOFactory.getInstance().doCreate(score);
				}
				else
				{
					score.setReplyscore(replyscore);
					double finalscore=(replyscore+score.getTutorscore())/2;
					score.setFinalscore(finalscore);
					flag=ScoresDAOFactory.getInstance().insert(stuID, score);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			  return flag;
		}
	//佘麻麻	
	//发布公告
		public boolean submitNotice(String managerID,String noticetitle,String noticehref,String noticedate,String download)
		{
			boolean flag=false;
			Notice notice=new Notice();
			notice.setManagerID(managerID);
			notice.setNoticetitle(noticetitle);
			notice.setNoticehref(noticehref);
			notice.setNoticedate(noticedate);
			notice.setDownload(download);
			try {
				flag=NoticeDAOFactory.getInstance().doCreate(notice);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
	//预览
}
