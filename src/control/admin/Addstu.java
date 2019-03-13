package control.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.AdminAction;
import model.excel.Addstuexcel;
import model.vo.Graduates;


public class Addstu extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName=req.getParameter("fileToUpload");
		List<Graduates> listExcel=Addstuexcel.getAllByExcel(fileName);
		String message1=null;
		String message2=null;
		
		boolean flag=false;
		AdminAction adAction=new AdminAction();
		
		int m=0;
		for(int i=0;i<listExcel.size();i++)
		{
			Graduates gra=new Graduates();
			
			gra.setStuID(listExcel.get(i).getStuID());
			gra.setStuName(listExcel.get(i).getStuName());
			gra.setStuPwd(listExcel.get(i).getStuPwd());
			gra.setTutorID(listExcel.get(i).getTutorID());
			gra.setFacultyID(listExcel.get(i).getFacultyID());
			gra.setClassname(listExcel.get(i).getClassname());
			gra.setYear(listExcel.get(i).getYear());
			
			try {
					flag=adAction.submitstu(gra);
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
			message1="录入成功！";
			
		}
		else
		{
			message1="录入失败！";
		}
		
		
		req.setAttribute("message1", message1);
	    req.getRequestDispatcher("admin/message.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
