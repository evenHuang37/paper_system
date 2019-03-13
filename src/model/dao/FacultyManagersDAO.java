package model.dao;

import java.util.List;

import model.vo.Facultymanagers;

public interface FacultyManagersDAO {
	public boolean doCreate(Facultymanagers facultymanager)throws Exception;  
    public List<Facultymanagers> findAll()throws Exception;  
    public Facultymanagers findById(String managerID)throws Exception;
    public List<Facultymanagers> findByFacultyId(String facultyID) throws Exception ;
}
