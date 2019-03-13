package model.dao;

import java.util.List;
import model.vo.Startreports;


public interface StartreportsDAO {
	public boolean doCreate(Startreports startreport)throws Exception;  
    public List<Startreports> findAll()throws Exception;  
    public Startreports findById(int startreportsID)throws Exception;
    public Startreports findByStuId(String stuID)throws Exception;
}
