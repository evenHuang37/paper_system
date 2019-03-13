package model.dao;
import java.util.List;
import model.vo.Faculties;

public interface FacultiesDAO {
	public boolean doCreate(Faculties faculty)throws Exception;  
    public List<Faculties> findAll()throws Exception;  
    public Faculties findById(String facultyID)throws Exception;

}
