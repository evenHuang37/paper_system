package model.daoProxy;

import java.util.List;

import model.dao.FacultyManagersDAO;
import model.daoImpl.FacultiesDAOImpl;
import model.daoImpl.FacultyManagersDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Facultymanagers;

public class FacultyManagersDAOProxy implements FacultyManagersDAO
{
	private DatabaseConnection dbc=null;
	private FacultyManagersDAO dao=null;
	public FacultyManagersDAOProxy() throws Exception
	{
		dbc=new DatabaseConnection();
		dao=new FacultyManagersDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Facultymanagers facultymanager) throws Exception {
		boolean flag=false;
		if(dao.findById(facultymanager.getManagerID())==null)
		{
			flag=dao.doCreate(facultymanager);
		}
		dbc.close();
		return flag;
	}

	@Override
	public List<Facultymanagers> findAll() throws Exception {
		List<Facultymanagers> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Facultymanagers findById(String managerID) throws Exception {
		Facultymanagers facultymanager=null;
		facultymanager=dao.findById(managerID);
		dbc.close();
		return facultymanager;
	}

	public List<Facultymanagers> findByFacultyId(String facultyID) throws Exception {
		List<Facultymanagers> list=dao.findByFacultyId(facultyID);
		dbc.close();
		return list;
	}

}
