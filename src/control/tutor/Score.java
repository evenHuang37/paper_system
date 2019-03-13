package control.tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.FamAction;
import model.action.GraAction;
import model.action.TutorAction;
import model.vo.ArticleStage;
import model.vo.Graduates;
import model.vo.Titles;

public class Score extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TutorAction tuAction=new TutorAction();
	    String tutorID=(String)req.getSession().getAttribute("userID");
//	    List<Graduates> getGraduates(String tutorID)
		List<Graduates> list=tuAction.getGraduates(tutorID);	
		req.setAttribute("list", list);	
		System.out.println(tutorID);
		req.getRequestDispatcher("admin/tutor_score.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TutorAction tuAction=new TutorAction();
	    String tutorID=(String)req.getSession().getAttribute("userID");
//	    List<Graduates> getGraduates(String tutorID)
		List<Graduates> list=tuAction.getGraduates(tutorID);	
		req.setAttribute("list", list);	
		System.out.println(tutorID);
		req.getRequestDispatcher("tutor_score.jsp").forward(req, resp);
		
	}
}
