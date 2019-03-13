package control.gra;

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
import model.vo.*;


public class GetScore extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GraAction grAction=new GraAction();
	    String stuID=(String)req.getSession().getAttribute("userID");

		Scores score=null;
		score=grAction.getScores(stuID);
		Graduates gra=null;
		gra=grAction.getInfo(stuID);
		req.setAttribute("name", gra.getStuName());
		req.setAttribute("stuID", gra.getStuID());
		if(score==null)
		{
			String tutorScore="";
			String replyScore="";
			String finalScore="";
			req.setAttribute("tutorScore", tutorScore);
			req.setAttribute("replyScore", replyScore);
			req.setAttribute("finalScore", finalScore);
		}
		else
		{
			String tutorScore=String.valueOf(score.getTutorscore());
			String replyScore=String.valueOf(score.getReplyscore());
			String finalScore=String.valueOf(score.getFinalscore());
			req.setAttribute("tutorScore", tutorScore);
			req.setAttribute("replyScore", replyScore);
			req.setAttribute("finalScore", finalScore);
		}
		
		
		
		
	
		req.getRequestDispatcher("admin/std_score.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
