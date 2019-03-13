package model.daoFactory;

import model.dao.StartreportsDAO;
import model.daoProxy.StartreportsDAOProxy;

public class StartreportsDAOFactory 
{
	public static StartreportsDAO getInstance()
	{
		StartreportsDAO dao=null;
		try {
			dao=new StartreportsDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
