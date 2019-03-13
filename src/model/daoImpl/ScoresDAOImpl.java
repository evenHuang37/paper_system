package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.ScoresDAO;
import model.vo.Scores;

public class ScoresDAOImpl implements ScoresDAO{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public ScoresDAOImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Scores score) throws Exception {
		String sql="insert into scores(stuID,tutorscore,replyscore,finalscore) values(?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, score.getStuID());
		stat.setDouble(2, score.getTutorscore());
		stat.setDouble(3, score.getReplyscore());
		stat.setDouble(4, score.getFinalscore());
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
	public boolean doUpdate(Scores score) throws Exception {
		String sql="update scores set name=?,sex=?,num=? where id=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, score.getStuID());
		stat.setDouble(2, score.getTutorscore());
		stat.setDouble(3, score.getReplyscore());
		stat.setDouble(4, score.getFinalscore());
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
	public List<Scores> findAll() throws Exception {
		String sql="select* from scores";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Scores score=null;
		List<Scores> list=new ArrayList<Scores>();
		while(rs.next())
		{
			String stuID=rs.getString(1);
			Double tutorscore=rs.getDouble(2);
			Double replyscore=rs.getDouble(3);
			Double finalscore=rs.getDouble(4);
			score=new Scores();
			score.setStuID(stuID);
			score.setTutorscore(tutorscore);
			score.setReplyscore(replyscore);
			score.setFinalscore(finalscore);
			list.add(score);
		}
		return list;
	}

	@Override
	public Scores findById(String stuID) throws Exception 
	{
		String sql="select * from scores where stuID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, stuID);
		ResultSet rs=stat.executeQuery();
		Scores score=null;
		while(rs.next())
		{
			Double tutorscore=rs.getDouble(2);
			Double replyscore=rs.getDouble(3);
			Double finalscore=rs.getDouble(4);
			score=new Scores();
			score.setTutorscore(tutorscore);
			score.setReplyscore(replyscore);
			score.setFinalscore(finalscore);
		}
		return score;
	}
	@Override
	public boolean insert(String stuID, Scores score) throws Exception {
		String sql="update scores set tutorscore=?,replyscore=?,finalscore=? where stuID=?";
		stat=conn.prepareStatement(sql);
		stat.setDouble(1, score.getTutorscore());
		stat.setDouble(2, score.getReplyscore());
		stat.setDouble(3, score.getFinalscore());
		stat.setString(4, stuID);
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
	
}
