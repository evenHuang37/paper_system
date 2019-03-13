package model.daoProxy;

import java.util.List;

import model.dbc.DatabaseConnection;
import model.dao.GraduatesDAO;
import model.daoImpl.GraduatesDAOImpl;
import model.vo.Graduates;

public class GraduatesDAOProxy implements GraduatesDAO
{
	private DatabaseConnection dbc; 
	private GraduatesDAO dao=null;
	public GraduatesDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new GraduatesDAOImpl(dbc.getConnection());
	}
	@Override
	public boolean doCreate(Graduates graduate) throws Exception {
		boolean flag=false;
		if(dao.findById(graduate.getStuID())==null)
		{
			flag=dao.doCreate(graduate);
		}
		dbc.close();
		return flag;
	}

	@Override
	public List<Graduates> findAll() throws Exception {
		List<Graduates> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Graduates findById(String stuID) throws Exception {
		Graduates graduate=null;
		graduate=dao.findById(stuID);
		dbc.close();
		return graduate;
	}
	@Override
	public List<Graduates> findByTutorID(String tutorID) throws Exception {
		List<Graduates> list=dao.findByTutorID(tutorID);
		dbc.close();
		return list;
	}
	@Override
	public List<Graduates> findByFacultyID(String facultyID) throws Exception {
		List<Graduates> list=dao.findByFacultyID(facultyID);
		dbc.close();
		return list;
	}
	

}
