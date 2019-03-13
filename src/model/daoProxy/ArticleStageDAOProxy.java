package model.daoProxy;

import java.util.List;

import model.dao.ArticleStageDAO;
import model.daoImpl.ArticleStageDAOImpl;
import model.daoImpl.ArticlesDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.ArticleStage;

public class ArticleStageDAOProxy implements ArticleStageDAO
{
	private DatabaseConnection dbc=null;
	private ArticleStageDAO dao=null;
	public ArticleStageDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new ArticleStageDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(ArticleStage aritcleStage) throws Exception {
		boolean flag=false;
		flag=dao.doCreate(aritcleStage);
		dbc.close();
		return flag;
	}

	@Override
	public List<ArticleStage> findAll() throws Exception {
		List<ArticleStage> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public ArticleStage findById(int stageID) throws Exception {
		ArticleStage articleStage=null;
		articleStage=dao.findById(stageID);
		dbc.close();
		return articleStage;
	}
	
	public List<ArticleStage> findByFacultyId(String facultyID) throws Exception {
		List<ArticleStage> list=dao.findByFacultyId(facultyID);
		dbc.close();
		return list;
	}

}
