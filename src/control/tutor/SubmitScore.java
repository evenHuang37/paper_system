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

public class SubmitScore extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
		TutorAction tuAction=new TutorAction();
	
		Double score0 = Double.parseDouble(req.getParameter("score0"));
		Double score1 = Double.parseDouble(req.getParameter("score1"));
		Double score2 = Double.parseDouble(req.getParameter("score2"));
		Double score3 = Double.parseDouble(req.getParameter("score3"));

	    System.out.println(score0);
	    String tutorID=(String)req.getSession().getAttribute("userID");
		List<Graduates> list=tuAction.getGraduates(tutorID);
	    String stuID0=list.get(0).getStuID();
	    String stuID1=list.get(1).getStuID();
	    String stuID2=list.get(2).getStuID();
	    String stuID3=list.get(3).getStuID();


        boolean flag=tuAction.submitTutorscore(stuID0, score0);
        boolean flag1=tuAction.submitTutorscore(stuID1, score1);
        boolean flag2=tuAction.submitTutorscore(stuID2, score2);
        boolean flag3=tuAction.submitTutorscore(stuID3, score3);
        String message1=null;
        if(flag)
	    {
	    	message1="录入成绩成功";
	    }
	    else
	    {
	    	message1="录入成绩失败";
	    }
        req.setAttribute("message1", message1);
		req.getRequestDispatcher("admin/message.jsp").forward(req, resp);
		
	}
}
