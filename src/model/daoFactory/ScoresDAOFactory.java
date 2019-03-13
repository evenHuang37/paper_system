package model.daoFactory;

import model.dao.ScoresDAO;
import model.daoProxy.ScoresDAOProxy;

public class ScoresDAOFactory 
{
	public static ScoresDAO getInstance()
	{
		ScoresDAO dao=null;
		try {
			dao=new ScoresDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
