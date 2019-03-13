package model.daoProxy;

import java.util.List;

import model.dao.ArticlesDAO;
import model.daoImpl.ArticlesDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Articles;

public class ArticlesDAOProxy implements ArticlesDAO
{
	private DatabaseConnection dbc=null;
	private ArticlesDAO dao=null;
	public ArticlesDAOProxy() throws Exception
	{
		dbc=new DatabaseConnection();
		dao=new ArticlesDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Articles article) throws Exception {
		boolean flag=false;
		flag=dao.doCreate(article);
		dbc.close();
		return flag;
	}

	@Override
	public List<Articles> findAll() throws Exception {
		List<Articles> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Articles findById(int articleID) throws Exception {
		Articles article=null;
		article=dao.findById(articleID);
		dbc.close();
		return article;
	}
	
	public List<Articles> findByStuId(String stuID) throws Exception {
		List<Articles> list=null;
		list=dao.findByStuId(stuID);
		dbc.close();
		return list;
	}

	@Override
	public boolean insert(int articleID, Articles article) throws Exception {
		boolean flag=dao.insert(articleID, article);
		return flag;
	}
}
