package model.dao;

import java.util.List;

import model.vo.Titles;

public interface TitlesDAO {
	public boolean doCreate(Titles title)throws Exception;  
    public List<Titles> findAll()throws Exception;  
    public Titles findById(int titleID)throws Exception;
    public List<Titles> findByFacultyID(String facultyID)throws Exception;
}

