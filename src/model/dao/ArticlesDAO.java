package model.dao;

import java.util.List;

import model.vo.Articles;

public interface ArticlesDAO {
	public boolean doCreate(Articles article)throws Exception;
	public boolean insert(int articleID,Articles article)throws Exception;
    public List<Articles> findAll()throws Exception;  
    public Articles findById(int articleID)throws Exception;
    public List<Articles> findByStuId(String stuID) throws Exception;

}
