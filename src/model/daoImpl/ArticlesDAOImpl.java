package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.ArticlesDAO;
import model.vo.Articles;

public class ArticlesDAOImpl implements ArticlesDAO
{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public ArticlesDAOImpl(Connection conn) 
	{
		this.conn=conn;
	}

	@Override
	public boolean doCreate(Articles article) throws Exception 
	{
		String sql="insert into articles(articletitle,stuID,articlehref,handindate)"
				+ " values(?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, article.getArticletitle());
		stat.setString(2, article.getStuID());
		stat.setString(3, article.getArticlehref());
		stat.setString(4, article.getHandindate());
		int update=stat.executeUpdate();
		if(update>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Articles> findAll() throws Exception 
	{
		String sql="select * from articles";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Articles article=null;
		List<Articles> list=new ArrayList<Articles>();
		while(rs.next())
		{
			int articleID=rs.getInt(1);
			String articletitle=rs.getString(2);
			String stuID=rs.getString(3);
			String articlehref=rs.getString(4);
			String handindate=rs.getString(5);
			article=new Articles();
			article.setArticleID(articleID);
			article.setArticletitle(articletitle);
			article.setStuID(stuID);
			article.setArticlehref(articlehref);
			article.setHandindate(handindate);
			list.add(article);
		}
		return list;
	}

	@Override
	public Articles findById(int articleID) throws Exception 
	{
		String sql="select * from articles where articleID=?";
		stat=conn.prepareStatement(sql);
		stat.setInt(1, articleID);
		ResultSet rs=stat.executeQuery();
		Articles article=new Articles();
		while(rs.next())
		{
			String articletitle=rs.getString(2);
			String stuID=rs.getString(3);
			String articlehref=rs.getString(4);
			String handindate=rs.getString(5);
			article=new Articles();
			article.setArticleID(articleID);
			article.setArticletitle(articletitle);
			article.setStuID(stuID);
			article.setArticlehref(articlehref);
			article.setHandindate(handindate);
		}
		return article;
	}

	public List<Articles> findByStuId(String stuID) throws Exception 
	{
		String sql="select * from articles where stuID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, stuID);
		ResultSet rs=stat.executeQuery();
		Articles article=new Articles();
		List<Articles> list=new ArrayList<Articles>();
		while(rs.next())
		{
			int articleID=rs.getInt(1);
			String articletitle=rs.getString(2);
			String articlehref=rs.getString(4);
			String handindate=rs.getString(5);
			article=new Articles();
			article.setArticleID(articleID);
			article.setArticletitle(articletitle);
			article.setStuID(stuID);
			article.setArticlehref(articlehref);
			article.setHandindate(handindate);
			list.add(article);
		    
		}
		return list;
	}

	@Override
	public boolean insert(int articleID, Articles article) throws Exception {
		String sql="update articles set articletitle=?,stuID=?,articlehref=?,handindate=? "
				+ "where articleID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, article.getArticletitle());
		stat.setString(2, article.getStuID());
		stat.setString(3, article.getArticlehref());
		stat.setString(4, article.getHandindate());
		stat.setInt(5, articleID);
		int update=stat.executeUpdate();
		if(update>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
