package model.daoFactory;

import model.dao.NoticeDAO;
import model.daoProxy.NoticeDAOProxy;

public class NoticeDAOFactory
{
	public static NoticeDAO getInstance()
	{
		NoticeDAO dao=null;
		try {
			dao=new NoticeDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
