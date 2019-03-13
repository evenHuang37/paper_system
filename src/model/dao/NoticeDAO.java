package model.dao;
import java.util.List;
import model.vo.Notice;

public interface NoticeDAO {
	public boolean doCreate(Notice notice)throws Exception;  
    public List<Notice> findAll()throws Exception;  
    public Notice findById(int noticeID)throws Exception;
    public List<Notice> findByManagerID(String managerID)throws Exception;
}
