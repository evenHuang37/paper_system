package control.fam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.FamAction;
import model.excel.ReadExcel;
import model.vo.Titles;

public class SubTitles extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName=req.getParameter("fileToUpload");
		List<Titles> listExcel=ReadExcel.getTitlesByExcel(fileName);
		String message1=null;
		boolean flag=false;
		String managerID=(String)req.getSession().getAttribute("userID");
		FamAction famAction=new FamAction();
		int m=0;
		for(int i=0;i<listExcel.size();i++)
		{
			int titleID=listExcel.get(i).getTitleID();
			String titleName=listExcel.get(i).getTitleName();
			//System.out.println(titleName);
			String titleAbstract=listExcel.get(i).getTitleAbstract();
			//System.out.println(titleAbstract);
			flag=famAction.submitTitles(titleID,titleName, managerID, titleAbstract);
			if(flag)
			{
				m++;
				flag=false;
			}
		}
		if(m==listExcel.size())
		{
			message1="发布选题成功！";
		}
		else
		{
			message1="发布选题失败！";
		}
		req.setAttribute("message1", message1);
	    req.getRequestDispatcher("admin/message.jsp").forward(req, resp);
	}
	
}
