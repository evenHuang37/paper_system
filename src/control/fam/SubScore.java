package control.fam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.FamAction;
import model.daoFactory.ScoresDAOFactory;
import model.excel.ReadExcel;
import model.vo.Scores;


public class SubScore extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName=req.getParameter("fileToUpload");
		List<Scores> listExcel=ReadExcel.getAllByExcel(fileName);
		String message1=null;
		String message2=null;
		boolean flag=false;
		FamAction famAction=new FamAction();
		int m=0;
		for(int i=0;i<listExcel.size();i++)
		{
			String stuID=listExcel.get(i).getStuID();
			double replyscore=listExcel.get(i).getReplyscore();
			try {
					flag=famAction.submitReplyscore(stuID, replyscore);
					if(flag)
				    {
						m++;
						flag=false;
				    	
				    }
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
		}
		if(m==listExcel.size())
		{
			message1="录入成绩成功！";
		}
		else
		{
			message1="录入成绩失败！";
		}
		
		
		req.setAttribute("message1", message1);
	    req.setAttribute("message2", message2);
	    req.getRequestDispatcher("admin/message.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
