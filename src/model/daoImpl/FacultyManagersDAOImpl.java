package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.FacultyManagersDAO;
import model.vo.Facultymanagers;

public class FacultyManagersDAOImpl implements FacultyManagersDAO
{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public FacultyManagersDAOImpl(Connection conn)
	{
		this.conn=conn;
	}

	@Override
	public boolean doCreate(Facultymanagers facultymanager) throws Exception {
		String sql="insert into facultymanagers(managerID,managerName,managerPwd,facultyID,"
				+ "email,telephone) values(?,?,?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, facultymanager.getManagerID());
		stat.setString(2, facultymanager.getManagerName());
		stat.setString(3, facultymanager.getManagerPwd());
		stat.setString(4, facultymanager.getFacultyID());
		stat.setString(5, facultymanager.getEmail());
		stat.setString(6, facultymanager.getTelephone());
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
	public List<Facultymanagers> findAll() throws Exception {
		String sql="select* from graduates";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Facultymanagers facultymanager=null;
		List<Facultymanagers> list=new ArrayList<Facultymanagers>();
		while(rs.next())
		{
			String managerID=rs.getString(1);
			String managerName=rs.getString(2);
			String managerPwd=rs.getString(3);
			String facultyID=rs.getString(4);
			String email=rs.getString(5);
			String telephone=rs.getString(6);
			facultymanager=new Facultymanagers();
			facultymanager.setManagerID(managerID);
			facultymanager.setManagerName(managerName);
			facultymanager.setManagerPwd(managerPwd);
			facultymanager.setFacultyID(facultyID);
			facultymanager.setEmail(email);
			facultymanager.setTelephone(telephone);
			list.add(facultymanager);
		}
		return list;
	}

	@Override
	public Facultymanagers findById(String managerID) throws Exception {
		String sql="select * from facultymanagers where managerID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, managerID);
		ResultSet rs=stat.executeQuery();
		Facultymanagers facultymanager=null;
		while(rs.next())
		{
			String managerName=rs.getString(2);
			String managerPwd=rs.getString(3);
			String facultyID=rs.getString(4);
			String email=rs.getString(5);
			String telephone=rs.getString(6);
			facultymanager=new Facultymanagers();
			facultymanager.setManagerID(managerID);
			facultymanager.setManagerName(managerName);
			facultymanager.setManagerPwd(managerPwd);
			facultymanager.setFacultyID(facultyID);
			facultymanager.setEmail(email);
			facultymanager.setTelephone(telephone);
		}
		return facultymanager;
	}

	public List<Facultymanagers> findByFacultyId(String facultyID) throws Exception {
		String sql="select * from facultymanagers where facultyID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, facultyID);
		ResultSet rs=stat.executeQuery();
		Facultymanagers facultymanager=null;
		List<Facultymanagers> list=new ArrayList<Facultymanagers>();
		while(rs.next())
		{
			String managerID=rs.getString(1);
			String managerName=rs.getString(2);
			String managerPwd=rs.getString(3);
			String email=rs.getString(5);
			String telephone=rs.getString(6);
			facultymanager=new Facultymanagers();
			facultymanager.setManagerID(managerID);
			facultymanager.setManagerName(managerName);
			facultymanager.setManagerPwd(managerPwd);
			facultymanager.setFacultyID(facultyID);
			facultymanager.setEmail(email);
			facultymanager.setTelephone(telephone);
			list.add(facultymanager);
		}
		return list;
	}
}
