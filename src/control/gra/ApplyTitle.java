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

public class ApplyTitle extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		GraAction grAction=new GraAction();
	    String title = req.getParameter("title");
	    String stuID=(String)req.getSession().getAttribute("userID");
	    String message1;
	    String message2;
        boolean flag=false;
        flag=grAction.submitArticleTitle(title, stuID);
        if(flag)
	    {
	    	message1="选题提交成功！";
	    }
	    else
	    {
	    	message1="选题提交失败！";
	    }
	    req.setAttribute("message1", message1);
	    req.getRequestDispatcher("admin/message.jsp").forward(req, resp);

	}
}
