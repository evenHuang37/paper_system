package control.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.AdminAction;
import model.daoFactory.*;
import model.excel.Addfaexcel;
import model.vo.*;


public class Addfa extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName=req.getParameter("fileToUpload");
		List<Facultymanagers> listExcel=Addfaexcel.getAllByExcel(fileName);
		String message1=null;
		
		boolean flag=false;
		AdminAction adAction=new AdminAction();
		
		int m=0;
		for(int i=0;i<listExcel.size();i++)
		{
			Facultymanagers fa=new Facultymanagers();
			
			fa.setManagerID(listExcel.get(i).getManagerID());
			fa.setManagerName(listExcel.get(i).getManagerName());
			fa.setManagerPwd(listExcel.get(i).getManagerPwd());
			fa.setEmail(listExcel.get(i).getEmail());
			fa.setTelephone(listExcel.get(i).getTelephone());
			fa.setFacultyID(listExcel.get(i).getFacultyID());
			
			
			try {
					flag=adAction.submitfa(fa);
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
