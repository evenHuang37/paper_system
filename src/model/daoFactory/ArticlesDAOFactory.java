package model.daoFactory;

import model.dao.ArticlesDAO;
import model.daoProxy.ArticlesDAOProxy;

public class ArticlesDAOFactory 
{
	public static ArticlesDAO getInstance()
	{
		ArticlesDAO dao=null;
		try {
			dao=new ArticlesDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
