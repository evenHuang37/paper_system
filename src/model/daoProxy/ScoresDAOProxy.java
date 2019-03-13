package model.daoProxy;

import java.util.List;

import model.dao.ScoresDAO;
import model.daoImpl.ScoresDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Scores;

public class ScoresDAOProxy implements ScoresDAO
{
	private DatabaseConnection dbc=null;
	private ScoresDAO dao=null;
	public ScoresDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new ScoresDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Scores score) throws Exception {
		boolean flag=false;
		if(dao.findById(score.getStuID())==null)
		{
			flag=dao.doCreate(score);
		}
		dbc.close();
		return flag;
	}

	@Override
	public List<Scores> findAll() throws Exception {
		List<Scores> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Scores findById(String stuID) throws Exception {
		Scores score=null;
		score=dao.findById(stuID);
		dbc.close();
		return score;
	}

	@Override
	public boolean insert(String stuID, Scores score) throws Exception {
		boolean flag=dao.insert(stuID, score);
		dbc.close();
		return flag;
	}

}
