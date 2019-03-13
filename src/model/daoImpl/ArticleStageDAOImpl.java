package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.ArticleStageDAO;
import model.vo.ArticleStage;

public class ArticleStageDAOImpl implements ArticleStageDAO
{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public ArticleStageDAOImpl(Connection conn) 
	{
		this.conn=conn;
	}

	@Override
	public boolean doCreate(ArticleStage articleStage) throws Exception {
		String sql="insert into articlestage(stageName,missionExplain,beginDate,"
				+ "endDate,facultyID) values(?,?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, articleStage.getStageName());
		stat.setString(2, articleStage.getMissionExplain());
		stat.setString(3, articleStage.getBeginDate());
		stat.setString(4, articleStage.getEndDate());
		stat.setString(5, articleStage.getFacultyID());
		int update=stat.executeUpdate();
		if(update>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<ArticleStage> findAll() throws Exception {
		String sql="select * from articlestage";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		ArticleStage articleStage=null;
		List<ArticleStage> list=new ArrayList<ArticleStage>();
		while(rs.next())
		{
			int stageID=rs.getInt(1);
			String stageName=rs.getString(2);
			String missionExplain=rs.getString(3);
			String beginDate=rs.getString(4);
			String endDate=rs.getString(5);
			String facultyID=rs.getString(6);
			articleStage=new ArticleStage();
			articleStage.setStageID(stageID);
			articleStage.setStageName(stageName);
			articleStage.setMissionExplain(missionExplain);
			articleStage.setBeginDate(beginDate);
			articleStage.setEndDate(endDate);
			articleStage.setFacultyID(facultyID);
			list.add(articleStage);
		}
		return list;
	}

	@Override
	public ArticleStage findById(int stageID) throws Exception {
		String sql="select * from articlestage where stageID=?";
		stat=conn.prepareStatement(sql);
		stat.setInt(1, stageID);
		ResultSet rs=stat.executeQuery();
		ArticleStage articleStage=null;
		while(rs.next())
		{
			String stageName=rs.getString(2);
			String missionExplain=rs.getString(3);
			String beginDate=rs.getString(4);
			String endDate=rs.getString(5);
			String facultyID=rs.getString(6);
			articleStage=new ArticleStage();
			articleStage.setStageID(stageID);
			articleStage.setStageName(stageName);
			articleStage.setMissionExplain(missionExplain);
			articleStage.setBeginDate(beginDate);
			articleStage.setEndDate(endDate);
			articleStage.setFacultyID(facultyID);
		}
		return articleStage;
	}
	
	public List<ArticleStage> findByFacultyId(String facultyID) throws Exception {
		String sql="select * from articlestage where facultyID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, facultyID);
		ResultSet rs=stat.executeQuery();
		ArticleStage articleStage=null;
		List<ArticleStage> list=new ArrayList<ArticleStage>();
		while(rs.next())
		{
			String stageName=rs.getString(2);
			String missionExplain=rs.getString(3);
			String beginDate=rs.getString(4);
			String endDate=rs.getString(5);
			int stageID=rs.getInt(1);
			articleStage=new ArticleStage();
			articleStage.setStageID(stageID);
			articleStage.setStageName(stageName);
			articleStage.setMissionExplain(missionExplain);
			articleStage.setBeginDate(beginDate);
			articleStage.setEndDate(endDate);
			articleStage.setFacultyID(facultyID);
			list.add(articleStage);
		}
		return list;
	}

}
