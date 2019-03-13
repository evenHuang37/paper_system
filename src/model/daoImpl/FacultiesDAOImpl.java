package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.FacultiesDAO;
import model.vo.Faculties;

public class FacultiesDAOImpl implements FacultiesDAO
{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public FacultiesDAOImpl(Connection conn) 
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Faculties faculty) throws Exception {
		String sql="insert into faculties(facultyID,facultyName) values(?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, faculty.getFacultyID());
		stat.setString(2, faculty.getFacultyName());
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
	public List<Faculties> findAll() throws Exception {
		String sql="select* from faculties";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Faculties faculty=null;
		List<Faculties> list=new ArrayList<Faculties>();
		while(rs.next())
		{
			String facultyID=rs.getString(1);
			String facultyName=rs.getString(2);
			faculty=new Faculties();
			faculty.setFacultyID(facultyID);
			faculty.setFacultyName(facultyName);
			list.add(faculty);
		}
		return list;
	}

	@Override
	public Faculties findById(String facultyID) throws Exception {
		String sql="select * from faculties where facultyID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, facultyID);
		ResultSet rs=stat.executeQuery();
		Faculties faculty=null;
		while(rs.next())
		{
			String facultyName=rs.getString(2);
			faculty=new Faculties();
			faculty.setFacultyID(facultyID);
			faculty.setFacultyName(facultyName);
		}
		return faculty;
	}
	
}
