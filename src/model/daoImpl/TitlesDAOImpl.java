package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.TitlesDAO;
import model.vo.Titles;

public class TitlesDAOImpl implements TitlesDAO{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public TitlesDAOImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Titles title) throws Exception {
		String sql="insert into titles(titleID,titleName,facultyID,titleAbstract) values(?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setInt(1, title.getTitleID());
		stat.setString(2, title.getTitleName());
		stat.setString(3, title.getFacultyID());
		stat.setString(4, title.getTitleAbstract());
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
	public List<Titles> findAll() throws Exception {
		String sql="select* from titles";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Titles title=null;
		List<Titles> list=new ArrayList<Titles>();
		while(rs.next())
		{
			int titleID=rs.getInt(1);
			String titleName=rs.getString(2);
			String facultyID=rs.getString(3);
			String titleAbstract=rs.getString(4);
			title=new Titles();
			title.setTitleID(titleID);
			title.setTitleName(titleName);
			title.setFacultyID(facultyID);
			title.setTitleAbstract(titleAbstract);
			list.add(title);
		}
		return list;
	}

	@Override
	public Titles findById(int titleID) throws Exception 
	{
		String sql="select * from titles where titleID=?";
		stat=conn.prepareStatement(sql);
		stat.setInt(1, titleID);
		ResultSet rs=stat.executeQuery();
		Titles title=null;
		while(rs.next())
		{
			String titleName=rs.getString(2);
			String facultyID=rs.getString(3);
			String titleAbstract=rs.getString(4);
			title=new Titles();
			title.setTitleID(titleID);
			title.setTitleName(titleName);
			title.setFacultyID(facultyID);
			title.setTitleAbstract(titleAbstract);
		}
		return title;
	}
	@Override
	public List<Titles> findByFacultyID(String facultyID)throws Exception 
	{
		String sql="select * from titles where facultyID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, facultyID);
		ResultSet rs=stat.executeQuery();
		Titles title=null;
		List<Titles> list=new ArrayList<Titles>();
		while(rs.next())
		{
			int titleID=rs.getInt(1);
			String titleName=rs.getString(2);
			String titleAbstract=rs.getString(4);
			title=new Titles();
			title.setTitleID(titleID);
			title.setTitleName(titleName);
			title.setFacultyID(facultyID);
			title.setTitleAbstract(titleAbstract);
			list.add(title);
		}
		return list;
	}
}
