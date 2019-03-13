package model.daoFactory;

import model.dao.GraduatesDAO;
import model.daoProxy.GraduatesDAOProxy;

public class GraduatesDAOFactory 
{
	public static GraduatesDAO getInstance()
	{
		GraduatesDAO dao=null;
		try {
			dao=new GraduatesDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
