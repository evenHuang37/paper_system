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

public class GetStage extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GraAction grAction=new GraAction();
	    String stuID=(String)req.getSession().getAttribute("userID");

		List<ArticleStage> list=grAction.getArticleStage(stuID);
		req.setAttribute("stage",list );
		
		req.getRequestDispatcher("admin/std_articlestage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
