package model.dao;

import java.util.List;

import model.vo.ArticleStage;

public interface ArticleStageDAO<articleStage> {
	public boolean doCreate(ArticleStage aritcleStage)throws Exception;  
    public List<ArticleStage> findAll()throws Exception;  
    public ArticleStage findById(int stageID)throws Exception;
    public List<ArticleStage> findByFacultyId(String facultyID) throws Exception;
}
