package model.daoProxy;

import java.util.List;

import model.dao.GraduatesDAO;
import model.dao.TitlesDAO;
import model.daoImpl.GraduatesDAOImpl;
import model.daoImpl.TitlesDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Graduates;
import model.vo.Titles;

public class TitlesDAOProxy implements TitlesDAO
{
	private DatabaseConnection dbc; 
	private TitlesDAO dao=null;
	public TitlesDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new TitlesDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Titles title) throws Exception {
		boolean flag=false;
		flag=dao.doCreate(title);
		dbc.close();
		return flag;
	}

	@Override
	public List<Titles> findAll() throws Exception {
		List<Titles> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Titles findById(int titleID) throws Exception {
		Titles title=null;
		title=dao.findById(titleID);
		dbc.close();
		return title;
	}
	@Override
	public List<Titles> findByFacultyID(String facultyID)throws Exception {
		List<Titles> list=null;
		list=dao.findByFacultyID(facultyID);
		dbc.close();
		return list;
	}
}
