package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.SysManagersDAO;
import model.vo.Sysmanagers;

public class SysManagersDAOImpl implements SysManagersDAO
{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public SysManagersDAOImpl(Connection conn)
	{
		this.conn=conn;
	}

	@Override
	public boolean doCreate(Sysmanagers sysmanager) throws Exception {
		String sql="insert into sysmanagers(sysmanagerID,sysmanagerPwd) values(?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, sysmanager.getSysmanagerID());
		stat.setString(2, sysmanager.getSysmanagerPwd());
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
	public List<Sysmanagers> findAll() throws Exception {
		String sql="select* from sysmanagers";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Sysmanagers sysmanager=null;
		List<Sysmanagers> list=new ArrayList<Sysmanagers>();
		while(rs.next())
		{
			String sysmanagerID=rs.getString(1);
			String sysmanagerPwd=rs.getString(2);
			sysmanager=new Sysmanagers();
			sysmanager.setSysmanagerID(sysmanagerID);
			sysmanager.setSysmanagerPwd(sysmanagerPwd);
			list.add(sysmanager);
		}
		return list;
	}

	@Override
	public Sysmanagers findById(String sysmanagerID) throws Exception {
		String sql="select* from sysmanagers where sysmanagerID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, sysmanagerID);
		ResultSet rs=stat.executeQuery();
		Sysmanagers sysmanager=null;
		while(rs.next())
		{
			String sysmanagerPwd=rs.getString(2);
			sysmanager=new Sysmanagers();
			sysmanager.setSysmanagerID(sysmanagerID);
			sysmanager.setSysmanagerPwd(sysmanagerPwd);
		}
		return sysmanager;
	}

}
