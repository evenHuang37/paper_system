package model.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.daoFactory.ArticleStageDAOFactory;
import model.daoFactory.ArticlesDAOFactory;
import model.daoFactory.GraduatesDAOFactory;
import model.daoFactory.MessageDAOFactory;
import model.daoFactory.NoticeDAOFactory;
import model.daoFactory.ScoresDAOFactory;
import model.daoFactory.StartreportsDAOFactory;
import model.daoFactory.TitlesDAOFactory;
import model.vo.ArticleStage;
import model.vo.Articles;
import model.vo.Graduates;
import model.vo.Message;
import model.vo.Notice;
import model.vo.Scores;
import model.vo.Startreports;
import model.vo.Titles;

public class GraAction 
{
	private Graduates graduate;
	//��ʾ��ҵ��������Ϣ
	public Graduates getInfo(String stuID)
	{
		try {
			graduate=GraduatesDAOFactory.getInstance().findById(stuID);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return graduate;
	}
	//��ҵ�����ױ�������ʾ
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
	
	//��ҵ������ʦ����
	//��ҵ������ʦ����
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

	
	//��ʾ�ҵ������б�
	 public List<String> getMessage(String stuID)
	 {
		   List<String> message = new ArrayList<String>();
  	   try {
  		   List<Message> messageinfo=MessageDAOFactory.getInstance().findByReceiverId(stuID);
			   Iterator iterator=messageinfo.iterator();
			  while(iterator.hasNext())
			  {
				  message.add(((Message)iterator.next()).getMessage());
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;   	  
     }

	
	 public List<ArticleStage> getArticleStage(String stuID)
	  {
	 	List<ArticleStage> articleStage = null;
	 	Graduates graduate=null;
	 	 try
	 	 {
	 		 graduate=GraduatesDAOFactory.getInstance().findById(stuID);
	 		 articleStage=ArticleStageDAOFactory.getInstance().findByFacultyId(graduate.getFacultyID());
	 	 }
	 	 catch(Exception e)
	 	 {
	 		 e.printStackTrace();
	 	 }
	 	 return articleStage;
	  }

	
	//��ʾѡ����Ϣ
	//��ʾѡ����Ϣ
		public List<Titles> getTitleInfo(String stuID)
		{
			List<Titles> titleList=new ArrayList<Titles>();
			Graduates graduate=null;
			try{
				graduate=GraduatesDAOFactory.getInstance().findById(stuID);
				titleList=TitlesDAOFactory.getInstance().findByFacultyID(graduate.getFacultyID());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return titleList;
		}

	 
	//��ҵ������ѡ��
		public boolean submitArticleTitle(String articletitle,String stuID)
		{
			Articles article=new Articles();
			article.setArticletitle(articletitle);
			article.setStuID(stuID); 
			article.setArticlehref(null);
			article.setHandindate(null);
			boolean flag=false;
			try {
				flag=ArticlesDAOFactory.getInstance().doCreate(article);
				
				System.out.println(flag);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
	
	//��ҵ���ύ���ⱨ��
		public boolean submitStartreports(int startreportsID,String stuID,String contexthref,String handindate)
		{
			boolean flag=false;
			Startreports startreport=new Startreports();
			startreport.setStartreportsID(startreportsID);
			startreport.setStuID(stuID);
			startreport.setContexthref(contexthref);
			startreport.setHandindate(handindate);
			try
			{
					flag = StartreportsDAOFactory.getInstance().doCreate(startreport);
			}			
				catch(Exception e)
				{
					e.printStackTrace();
				}
			
			return flag;
		}

	
	//��ҵ���ύ����
		public boolean submitArticle(String stuID,String articlehref,String handindate)
		{
			boolean flag=false;
			Articles article=new Articles();
			article.setStuID(stuID);
			article.setArticlehref(articlehref);
			article.setHandindate(handindate);
			try {
				List<Articles> list = ArticlesDAOFactory.getInstance().findByStuId(stuID);
				article.setArticletitle(list.get(list.size()-1).getArticletitle());
				if(list.size()==1&&(list.get(list.size()-1).getArticlehref()==null))
				{
					int articleID=list.get(list.size()-1).getArticleID();
					flag=ArticlesDAOFactory.getInstance().insert(articleID, article);
				}
				else
				{
					
					flag=ArticlesDAOFactory.getInstance().doCreate(article);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
	//���ѧ���ɼ�
	  public Scores getScores(String stuID)
	  {
		  Scores score=null;
		  try {
			  score=ScoresDAOFactory.getInstance().findById(stuID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return score;
	  }
	
	  //������ϢԤ������Ϊ�����û������������һ���ģ�ǰ��Ҳ�ǹ��õģ�����Ҫ��Ҫ�ֿ�дaction���д�˼��


	
}
