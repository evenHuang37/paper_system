package control.fam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.FamAction;

public class SubStageInfo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String[] stage=req.getParameterValues("stage");
		String[] abstracts=req.getParameterValues("abstracts");
		String[] beginDate=req.getParameterValues("beginDate");
		String[] endDate=req.getParameterValues("endDate");
		String managerID=(String)req.getSession().getAttribute("userID");
		int length=stage.length;
		FamAction famAction=new FamAction();
		boolean flag=false;
		int m=0;
		for(int i=0;i<length;i++)
		{
			System.out.println(stage[i]);
			System.out.println(abstracts[i]);
			flag=famAction.submitArticleStage(managerID, stage[i], abstracts[i], beginDate[i], endDate[i]);
			if(flag)
			{
				m++;
				flag=false;
			}
		}
		System.out.println(m);
		String message1=null;
		if(m==length)
		{
			message1="发布论文阶段信息成功";
		}
		else
		{
			message1="发布论文阶段信息失败";
		}
		req.setAttribute("message1", message1);
		req.getRequestDispatcher("admin/message.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
