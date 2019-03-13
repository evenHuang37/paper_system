package model.daoProxy;

import java.util.List;

import model.dao.GraduatesDAO;
import model.dao.SysManagersDAO;
import model.daoImpl.GraduatesDAOImpl;
import model.daoImpl.SysManagersDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Graduates;
import model.vo.Sysmanagers;

public class SysManagersDAOProxy implements SysManagersDAO
{
	private DatabaseConnection dbc; 
	private SysManagersDAO dao=null;
	public SysManagersDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new SysManagersDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Sysmanagers sysmanager) throws Exception {
		boolean flag=false;
		if(dao.findById(sysmanager.getSysmanagerID())==null)
		{
			flag=dao.doCreate(sysmanager);
		}
		dbc.close();
		return flag;
	}

	@Override
	public List<Sysmanagers> findAll() throws Exception {
		List<Sysmanagers> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Sysmanagers findById(String sysmanagerID) throws Exception {
		Sysmanagers sysmanager=null;
		sysmanager=dao.findById(sysmanagerID);
		dbc.close();
		return sysmanager;
	}

}
