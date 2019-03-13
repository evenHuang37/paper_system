package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.GraduatesDAO;
import model.vo.Graduates;

public class GraduatesDAOImpl implements GraduatesDAO
{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public GraduatesDAOImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Graduates graduate) throws Exception {
		String sql="insert into graduates(stuID,stuName,stuPwd,tutorID,facultyID,classname,year) values(?,?,?,?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, graduate.getStuID());
		stat.setString(2, graduate.getStuName());
		stat.setString(3, graduate.getStuPwd());
		stat.setString(4, graduate.getTutorID());
		stat.setString(5, graduate.getFacultyID());
		stat.setString(6, graduate.getClassname());
		stat.setString(7, graduate.getYear());
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
	public List<Graduates> findAll() throws Exception {
		String sql="select* from graduates";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Graduates graduate=null;
		List<Graduates> list=new ArrayList<Graduates>();
		while(rs.next())
		{
			String stuID=rs.getString(1);
			String stuName=rs.getString(2);
			String stuPwd=rs.getString(3);
			String tutorID=rs.getString(4);
			String facultyID=rs.getString(5);
			String classname=rs.getString(6);
			String year=rs.getString(7);
			graduate=new Graduates();
			graduate.setStuID(stuID);
			graduate.setStuName(stuName);
			graduate.setStuPwd(stuPwd);
			graduate.setTutorID(tutorID);
			graduate.setFacultyID(facultyID);
			graduate.setYear(year);
			list.add(graduate);
		}
		return list;
	}

	@Override
	public Graduates findById(String stuID) throws Exception 
	{
		String sql="select * from graduates where stuID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, stuID);
		ResultSet rs=stat.executeQuery();
		Graduates graduate=null;
		while(rs.next())
		{
			String stuName=rs.getString(2);
			String stuPwd=rs.getString(3);
			String tutorID=rs.getString(4);
			String facultyID=rs.getString(5);
			String classname=rs.getString(6);
			String year=rs.getString(7);
			graduate=new Graduates();
			graduate.setStuID(stuID);
			graduate.setStuName(stuName);
			graduate.setStuPwd(stuPwd);
			graduate.setTutorID(tutorID);
			graduate.setFacultyID(facultyID);
			graduate.setClassname(classname);
			graduate.setYear(year);
		}
		return graduate;
	}
	@Override
	public List<Graduates> findByTutorID(String tutorID) throws Exception {
		String sql="select * from graduates where tutorID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, tutorID);
		ResultSet rs=stat.executeQuery();
		Graduates graduate=null;
		List<Graduates> list=new ArrayList<Graduates>();
		while(rs.next())
		{
			String stuID=rs.getString(1);
			String stuName=rs.getString(2);
			String stuPwd=rs.getString(3);
			String facultyID=rs.getString(5);
			String classname=rs.getString(6);
			String year=rs.getString(7);
			graduate=new Graduates();
			graduate.setStuID(stuID);
			graduate.setStuName(stuName);
			graduate.setStuPwd(stuPwd);
			graduate.setTutorID(tutorID);
			graduate.setFacultyID(facultyID);
			graduate.setClassname(classname);
			graduate.setYear(year);
			list.add(graduate);
		}
		return list;
	}
	@Override
	public List<Graduates> findByFacultyID(String facultyID) throws Exception {
		String sql="select * from graduates where facultyID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, facultyID);
		ResultSet rs=stat.executeQuery();
		Graduates graduate=null;
		List<Graduates> list=new ArrayList<Graduates>();
		while(rs.next())
		{
			String stuID=rs.getString(1);
			String stuName=rs.getString(2);
			String stuPwd=rs.getString(3);
			String tutorID=rs.getString(4);
			String classname=rs.getString(6);
			String year=rs.getString(7);
			graduate=new Graduates();
			graduate.setStuID(stuID);
			graduate.setStuName(stuName);
			graduate.setStuPwd(stuPwd);
			graduate.setTutorID(tutorID);
			graduate.setFacultyID(facultyID);
			graduate.setClassname(classname);
			graduate.setYear(year);
			list.add(graduate);
		}
		return list;
	}

}
