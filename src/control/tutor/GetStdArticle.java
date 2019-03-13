package control.tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.TutorAction;
import model.daoFactory.ArticlesDAOFactory;
import model.vo.Articles;
import model.vo.Graduates;

public class GetStdArticle extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TutorAction tutorAction=new TutorAction();
		String tutorID=(String)req.getSession().getAttribute("userID");
		List<Graduates> graduateList=tutorAction.getGraduates(tutorID);
		List<StdArticleBean> list=new ArrayList<StdArticleBean>();
		for(int i=0;i<graduateList.size();i++)
		{
			try 
			{
				String graID=graduateList.get(i).getStuID();
				String graName=graduateList.get(i).getStuName();
				List<Articles> ArtList=ArticlesDAOFactory.getInstance().findByStuId(graID);
				String articleTitle=ArtList.get(0).getArticletitle();
				String state;
				if(articleTitle.equals(""))
				{
				    state="未定题";
				}
				else
				{
					state="已定题";
				}
				StdArticleBean sab=new StdArticleBean();
				sab.setGraName(graName);
				sab.setGraID(graID);
				sab.setArticleTitle(articleTitle);
				sab.setState(state);
				list.add(sab);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("admin/tutor_stdarticle.jsp").forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
		
		
	}
}
