package model.dao;

import java.util.List;

import model.vo.Scores;

public interface ScoresDAO {
	public boolean doCreate(Scores score)throws Exception;
	public boolean insert(String stuID,Scores score)throws Exception;
    public List<Scores> findAll()throws Exception;  
    public Scores findById(String stuID)throws Exception;

}
