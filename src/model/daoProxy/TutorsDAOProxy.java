package model.daoProxy;

import java.util.List;

import model.dao.TutorsDAO;
import model.daoImpl.TutorsDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Graduates;
import model.vo.Tutors;

public class TutorsDAOProxy implements TutorsDAO
{
	private DatabaseConnection dbc; 
	private TutorsDAO dao=null;
	public TutorsDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new TutorsDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Tutors tutor) throws Exception {
		boolean flag=false;
		if(dao.findById(tutor.getTutorID())==null)
		{
			flag=dao.doCreate(tutor);
		}
		dbc.close();
		return flag;
	}

	@Override
	public List<Tutors> findAll() throws Exception {
		List<Tutors> list=dao.findAll();
		dbc.close();
		return list;
	}
	@Override
	public Tutors findById(String tutorID) throws Exception {
		Tutors tutor=null;
		tutor=dao.findById(tutorID);
		dbc.close();
		return tutor;
	}

	@Override
	public List<Tutors> findByFacultyID(String facultyID) throws Exception {
		List<Tutors> list=dao.findByFacultyID(facultyID);
		dbc.close();
		return list;
	}
}
