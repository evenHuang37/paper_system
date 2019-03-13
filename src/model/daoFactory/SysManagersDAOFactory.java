package model.daoFactory;

import model.dao.SysManagersDAO;
import model.daoProxy.SysManagersDAOProxy;

public class SysManagersDAOFactory 
{
	public static SysManagersDAO getInstance()
	{
		SysManagersDAO dao=null;
		try {
			dao=new SysManagersDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
