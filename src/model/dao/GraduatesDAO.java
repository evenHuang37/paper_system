package model.dao;

import java.util.List;

import model.vo.Graduates;


public interface GraduatesDAO 
{
	public boolean doCreate(Graduates graduate)throws Exception;  
    public List<Graduates> findAll()throws Exception;  
    public Graduates findById(String stuID)throws Exception;
    public List<Graduates> findByTutorID(String tutorID)throws Exception;
    public List<Graduates> findByFacultyID(String facultyID)throws Exception;
}
