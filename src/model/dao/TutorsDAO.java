package model.dao;
import java.util.List;
import model.vo.Tutors;

public interface TutorsDAO {
	public boolean doCreate(Tutors tutor)throws Exception;  
    public List<Tutors> findAll()throws Exception;  
    public Tutors findById(String tutorID)throws Exception;
    public List<Tutors> findByFacultyID(String facultyID)throws Exception;
}
