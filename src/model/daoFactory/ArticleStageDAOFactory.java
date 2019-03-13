package model.daoFactory;

import model.dao.ArticleStageDAO;
import model.daoProxy.ArticleStageDAOProxy;
import model.daoProxy.ArticlesDAOProxy;

public class ArticleStageDAOFactory 
{
	public static ArticleStageDAO getInstance()
	{
		ArticleStageDAO dao=null;
		try {                                                                                                                                                                                                                                   
			dao=new ArticleStageDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
