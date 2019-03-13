package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.StartreportsDAO;
import model.vo.Scores;
import model.vo.Startreports;

public class StartreportsDAOImpl implements StartreportsDAO
{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public StartreportsDAOImpl(Connection conn)
	{
		this.conn=conn;
	}

	@Override
	public boolean doCreate(Startreports startreport) throws Exception {
		String sql="insert into startreports(stuID,contexthref,handindate)"
				+ "values(?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, startreport.getStuID());
		stat.setString(2, startreport.getContexthref());
		stat.setString(3, startreport.getHandindate());
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
	public List<Startreports> findAll() throws Exception {
		String sql="select* from startreports";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Startreports startreport=null;
		List<Startreports> list=new ArrayList<Startreports>();
		while(rs.next())
		{
			int startreportsID=rs.getInt(1);
			String stuID=rs.getString(2);
			String contexthref=rs.getString(3);
			String handindate=rs.getString(4);
			startreport=new Startreports();
			startreport.setStartreportsID(startreportsID);
			startreport.setStuID(stuID);
			startreport.setContexthref(contexthref);
			startreport.setHandindate(handindate);
			list.add(startreport);
		}
		return list;
	}

	@Override
	public Startreports findById(int startreportsID) throws Exception {
		String sql="select * from startreports where startreportsID=?";
		stat=conn.prepareStatement(sql);
		stat.setInt(1, startreportsID);
		ResultSet rs=stat.executeQuery();
		Startreports startreport=null;
		while(rs.next())
		{
			String stuID=rs.getString(2);
			String contexthref=rs.getString(3);
			String handindate=rs.getString(4);
			startreport=new Startreports();
			startreport.setStartreportsID(startreportsID);
			startreport.setStuID(stuID);
			startreport.setContexthref(contexthref);
			startreport.setHandindate(handindate);
		}
		return startreport;
	}

	public Startreports findByStuId(String stuID)throws Exception
	{
		String sql="select * from startreports where stuID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, stuID);
		ResultSet rs=stat.executeQuery();
		Startreports startreport=null;
		while(rs.next())
		{
			int startreportsID=rs.getInt(1);
			String contexthref=rs.getString(3);
			String handindate=rs.getString(4);
			startreport=new Startreports();
			startreport.setStartreportsID(startreportsID);
			startreport.setStuID(stuID);
			startreport.setContexthref(contexthref);
			startreport.setHandindate(handindate);
		}
		return startreport;
	}
}
