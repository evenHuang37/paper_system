package model.daoFactory;

import model.dao.MessageDAO;
import model.daoProxy.MessageDAOProxy;

public class MessageDAOFactory 
{
	public static MessageDAO getInstance()
	{
		MessageDAO dao=null;
		try {
			dao=new MessageDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
