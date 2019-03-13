package model.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.daoFactory.ArticlesDAOFactory;
import model.daoFactory.GraduatesDAOFactory;
import model.daoFactory.MessageDAOFactory;
import model.daoFactory.NoticeDAOFactory;
import model.daoFactory.ScoresDAOFactory;
import model.daoFactory.StartreportsDAOFactory;
import model.daoFactory.TutorsDAOFactory;
import model.vo.Articles;
import model.vo.Graduates;
import model.vo.Message;
import model.vo.Notice;
import model.vo.Scores;
import model.vo.Startreports;
import model.vo.Tutors;

public class TutorAction 
{
	//佘麻麻
	//获得导师个人信息
	public Tutors getInfo(String tutorID)
	{
		Tutors tutor=new Tutors();
		try {
			tutor=TutorsDAOFactory.getInstance().findById(tutorID);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return tutor;
	}
	
	//导师论文套表下载显示
		public List<String> getHref()
		{
			List<String> href=new ArrayList<String>();
			try {
				List<Notice> notice=NoticeDAOFactory.getInstance().findAll();
				Iterator iterator = notice.iterator();
				while(iterator.hasNext())
				{
					Notice n=(Notice)iterator.next();
					href.add(n.getDownload());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return href;
		}
		
	//上传参考文献没有数据库
		
	//导师给学生留言
	  public boolean saveMessage(String senderID,String receiverID,String message,String sendDate)
	  {
		  boolean flag=false;
		  Message messages=new Message();
		  messages.setSenderID(senderID);
		  messages.setReceiverID(receiverID);
		  messages.setMessage(message);
		  messages.setSendDate(sendDate);
		  try {
			  flag=MessageDAOFactory.getInstance().doCreate(messages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return flag;
	  }
	  
	  //怡宝
	 //获得导师留言表
	  public List<String> getMessage(String receiverID){
			List<String> message = new ArrayList<String>();
	 		   List<Message> messageinfo;
			try {
				messageinfo = MessageDAOFactory.getInstance().findByReceiverId(receiverID);
				 Iterator iterator=messageinfo.iterator();
				  while(iterator.hasNext())
				  {
					  message.add(((Message)iterator.next()).getMessage());
				  }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		  
				return message;
		}
	  
	  //怡宝
	  //获得导师所带毕业生
	  public List<Graduates> getGraduates(String tutorID)
	  {
		  List<Graduates> graduates = new ArrayList<Graduates>();
			try {
				graduates=GraduatesDAOFactory.getInstance().findByTutorID(tutorID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return graduates;		
	  }
	  //怡宝
	  //获得毕业生论文，通过上面那个方法获得毕业生ID
	  public List<Articles> getArticles(String stuID)
	  {
		  List<Articles> articles = new ArrayList<Articles>();
			try {
				articles=ArticlesDAOFactory.getInstance().findByStuId(stuID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return articles;	
	  }
	  
	  //佘麻麻
	  //获得开题报告
	  public Startreports getStartreports(String stuID)
	  {
		  Startreports startreport = null;
			try {
				startreport=StartreportsDAOFactory.getInstance().findByStuId(stuID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return startreport;
	  }
	  
	  //42
	  //提交毕业生论文成绩
	  public boolean submitTutorscore(String stuID,double tutorscore)
	  {
		  Scores score=null;
		  boolean flag=false;
		  try {
			score=ScoresDAOFactory.getInstance().findById(stuID);
			if(score==null)
			{
				score=new Scores();
				score.setStuID(stuID);
				score.setTutorscore(tutorscore);
				score.setReplyscore(0);
				score.setFinalscore(0);
				flag=ScoresDAOFactory.getInstance().doCreate(score);
			}
			else
			{
				score.setTutorscore(tutorscore);
				double finalscore=(tutorscore+score.getReplyscore())/2;
				score.setFinalscore(finalscore);
				flag=ScoresDAOFactory.getInstance().insert(stuID, score);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  return flag;
		  
	  }
	  
	  //公告信息预览

}
