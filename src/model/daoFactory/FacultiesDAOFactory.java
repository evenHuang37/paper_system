package model.daoFactory;

import model.dao.FacultiesDAO;
import model.daoProxy.FacultiesDAOProxy;

public class FacultiesDAOFactory 
{
	public static FacultiesDAO getInstance()
	{
		FacultiesDAO dao=null;
		try {
			dao=new FacultiesDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
}
