package control.tutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.GraAction;
import model.daoFactory.ArticlesDAOFactory;
import model.daoFactory.StartreportsDAOFactory;
import model.vo.Articles;
import model.vo.Startreports;



public class FindStuArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String stuID=null;
		stuID=request.getParameter("stuID");
		System.out.println(stuID);
//		String stuName=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		List<MArticleBean> list=new ArrayList<MArticleBean>();
	    try {
         	Startreports startreports=StartreportsDAOFactory.getInstance().findByStuId(stuID);
	    	List<Articles> articles=ArticlesDAOFactory.getInstance().findByStuId(stuID);
	    	MArticleBean mnArticle=new MArticleBean();
			mnArticle.setHandedType("开题报告");
		    mnArticle.setHandinTime(startreports.getHandindate());
		    mnArticle.setDownloadHref(startreports.getContexthref());
			list.add(mnArticle);
			for(int i=0;i<list.size();i++)
			{
				MArticleBean mnArticle2=new MArticleBean();
				String handinTime=articles.get(i).getHandindate();
				String href=articles.get(i).getArticlehref();
				mnArticle2.setHandedType("论文"+i+1);
				mnArticle2.setHandinTime(handinTime);
				mnArticle2.setDownloadHref(href);
				list.add(mnArticle2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        request.setAttribute("list", list);
		request.getRequestDispatcher("admin/tutor_article.jsp").forward(request, response);
	}

}
