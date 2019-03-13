package model.daoProxy;

import java.util.List;

import model.dao.FacultiesDAO;
import model.daoImpl.FacultiesDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Faculties;

public class FacultiesDAOProxy implements FacultiesDAO
{
	private DatabaseConnection dbc=null;
	private FacultiesDAO dao=null;
	public FacultiesDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new FacultiesDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Faculties faculty) throws Exception {
		boolean flag=false;
		if(dao.findById(faculty.getFacultyID())==null)
		{
			flag=dao.doCreate(faculty);
		}
		dbc.close();
		return flag;
	}

	@Override
	public List<Faculties> findAll() throws Exception {
		List<Faculties> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Faculties findById(String facultyID) throws Exception {
		Faculties faculties=null;
		faculties=dao.findById(facultyID);
		dbc.close();
		return faculties;
	}

}
