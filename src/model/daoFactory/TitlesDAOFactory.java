package model.daoFactory;

import model.dao.TitlesDAO;
import model.daoProxy.TitlesDAOProxy;

public class TitlesDAOFactory 
{
	public static TitlesDAO getInstance()
	{
		TitlesDAO dao=null;
		try {
			dao=new TitlesDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
