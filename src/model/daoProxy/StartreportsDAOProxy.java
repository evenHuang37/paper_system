package model.daoProxy;

import java.util.List;

import model.dao.StartreportsDAO;
import model.daoImpl.StartreportsDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Startreports;

public class StartreportsDAOProxy implements StartreportsDAO
{
	private DatabaseConnection dbc=null;
	private StartreportsDAO dao=null;
	public StartreportsDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new StartreportsDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Startreports startreport) throws Exception {
		boolean flag=false;
		flag=dao.doCreate(startreport);
		dbc.close();
		return flag;
	}

	@Override
	public List<Startreports> findAll() throws Exception {
		List<Startreports> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Startreports findById(int startreportsID) throws Exception {
		Startreports startreport=null;
		startreport=dao.findById(startreportsID);
		dbc.close();
		return startreport;
	}
	public Startreports findByStuId(String stuID)throws Exception
	{
		Startreports startreport=null;
		startreport=dao.findByStuId(stuID);
		dbc.close();
		return startreport;
	}
	
	
}
