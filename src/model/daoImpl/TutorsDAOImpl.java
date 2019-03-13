package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.TutorsDAO;
import model.vo.Tutors;

public class TutorsDAOImpl implements TutorsDAO {
	private Connection conn=null;
	private PreparedStatement stat=null;
	public TutorsDAOImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Tutors tutors) throws Exception {
		String sql="insert into tutors(tutorID,tutorName,tutorPwd,facultyID,profession) values(?,?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, tutors.getTutorID());
		stat.setString(2, tutors.getTutorName());
		stat.setString(3, tutors.getTutorPwd());
		stat.setString(4, tutors.getFacultyID());
		stat.setString(5, tutors.getProfession());
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
	public List<Tutors> findAll() throws Exception {
		String sql="select * from tutors";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Tutors tutors=null;
		List<Tutors> list=new ArrayList<Tutors>();
		while(rs.next())
		{
			String tutorID=rs.getString(1);
			String tutorName=rs.getString(2);
			String tutorPwd=rs.getString(3);
			String facultyID=rs.getString(4);
			String profession=rs.getString(5);
			tutors=new Tutors();
			tutors.setTutorID(tutorID);;
			tutors.setTutorName(tutorName);;
			tutors.setTutorPwd(tutorPwd);;
			tutors.setFacultyID(facultyID);;
			tutors.setProfession(profession);;
			list.add(tutors);
		}
		return list;
	}

	@Override
	public Tutors findById(String tutorID) throws Exception 
	{
		String sql="select * from tutors where tutorID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, tutorID);
		ResultSet rs=stat.executeQuery();
		Tutors tutors=null;
		while(rs.next())
		{
			String tutorName=rs.getString(2);
			String tutorPwd=rs.getString(3);
			String facultyID=rs.getString(4);
			String profession=rs.getString(5);
			tutors=new Tutors();
			tutors.setTutorID(tutorID);
			tutors.setTutorName(tutorName);
			tutors.setTutorPwd(tutorPwd);
			tutors.setFacultyID(facultyID);
			tutors.setProfession(profession);
		}
		return tutors;
	}
	public List<Tutors> findByFacultyID(String facultyID) throws Exception 
	{
		String sql="select * from tutors where facultyID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, facultyID);
		ResultSet rs=stat.executeQuery();
		Tutors tutors=null;
		List<Tutors> list=new ArrayList<Tutors>();
		while(rs.next())
		{
			String tutorID=rs.getString(1);
			String tutorName=rs.getString(2);
			String tutorPwd=rs.getString(3);
			String profession=rs.getString(5);
			tutors=new Tutors();
			tutors.setTutorID(tutorID);
			tutors.setTutorName(tutorName);
			tutors.setTutorPwd(tutorPwd);
			tutors.setProfession(profession);
			list.add(tutors);
		}
		return list;
	}
}
