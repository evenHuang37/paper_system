package model.daoFactory;

import model.dao.TutorsDAO;
import model.daoProxy.TutorsDAOProxy;

public class TutorsDAOFactory 
{
	public static TutorsDAO getInstance()
	{
		TutorsDAO dao=null;
		try {
			dao=new TutorsDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
