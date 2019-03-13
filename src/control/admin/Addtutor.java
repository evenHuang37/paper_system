package control.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.AdminAction;
import model.excel.ReadTutorExcel;
import model.vo.Tutors;


public class Addtutor extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName=req.getParameter("fileToUpload");
		List<Tutors> listExcel=ReadTutorExcel.getAllByExcel(fileName);
		String message1=null;
		boolean flag=false;
		AdminAction adminAction=new AdminAction();
		int m=0;
		for(int i=0;i<listExcel.size();i++)
		{
			Tutors tutors=new Tutors();
			tutors.setTutorID(listExcel.get(i).getTutorID());
			tutors.setTutorName(listExcel.get(i).getTutorName());
			tutors.setTutorPwd(listExcel.get(i).getTutorPwd());
			tutors.setFacultyID(listExcel.get(i).getFacultyID());
			tutors.setProfession(listExcel.get(i).getProfession());
			try {
					flag=adminAction.submitTutors(tutors);
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
			message1="录入导师信息成功！";
		}
		else
		{
			message1="录入导师信息成功！";
		}
		
		
		req.setAttribute("message1", message1);
	    req.getRequestDispatcher("admin/message.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}