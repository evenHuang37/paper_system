package model.daoFactory;

import model.dao.FacultyManagersDAO;
import model.daoProxy.FacultyManagersDAOProxy;

public class FacultyManagersDAOFactory 
{
	public static FacultyManagersDAO getInstance()
	{
		FacultyManagersDAO dao=null;
		try {
			dao=new FacultyManagersDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
