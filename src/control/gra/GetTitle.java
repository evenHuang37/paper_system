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
import model.vo.ArticleStage;
import model.vo.Graduates;
import model.vo.Titles;

public class GetTitle extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GraAction grAction=new GraAction();
	    String stuID=(String)req.getSession().getAttribute("userID");

		List<Titles> list=grAction.getTitleInfo(stuID);	
		req.setAttribute("list", list);	
		req.getRequestDispatcher("admin/std_titleinfo.jsp").forward(req, resp);
	}
}
