package control.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.action.AdminAction;
import model.action.FamAction;
import model.action.GraAction;
import model.action.TutorAction;
import model.vo.Faculties;
import model.vo.Facultymanagers;
import model.vo.Graduates;
import model.vo.Sysmanagers;
import model.vo.Tutors;

public class Login extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userID=req.getParameter("userID");
		String userPwd=req.getParameter("userPwd");
		String role=req.getParameter("role");
		req.getSession().setAttribute("userID", userID);
		req.getSession().setAttribute("role", role);
		System.out.println(userID);
		System.out.println(userPwd);
		System.out.println(role);
		if(role.equals("毕业生"))
		{
			GraAction graAction=new GraAction();
			Graduates graduate=graAction.getInfo(userID);
			if(graduate.getStuPwd().equals(userPwd))
			{
				System.out.println("heng");
				req.getRequestDispatcher("admin/std_index.jsp").forward(req, resp);
			}
			else
			{
				req.getRequestDispatcher("admin/LoginFail.jsp").forward(req, resp);
			}
		}
		if(role.equals("导师"))
		{
			TutorAction tutorAction=new TutorAction();
			Tutors tutor=tutorAction.getInfo(userID);
			if(tutor.getTutorPwd().equals(userPwd))
			{
				req.getRequestDispatcher("admin/tutor_index.jsp").forward(req, resp);
			}
			else
			{
				req.getRequestDispatcher("admin/LoginFail.jsp").forward(req, resp);
			}
		}
		if(role.equals("院系教务管理人员"))
		{
			FamAction famAction=new FamAction();
			Facultymanagers famanager=famAction.getInfo(userID);
			if(famanager.getManagerPwd().equals(userPwd))
			{
				req.getRequestDispatcher("admin/fm_index.jsp").forward(req, resp);
			}
			else
			{
				req.getRequestDispatcher("admin/LoginFail.jsp").forward(req, resp);
			}
		}
		if(role.equals("管理员"))
		{
			AdminAction adminAction=new AdminAction();
			Sysmanagers sysManager=adminAction.getSysmanagerInfo(userID);
			if(sysManager.getSysmanagerPwd().equals(userPwd))
			{
				req.getRequestDispatcher("admin/admin_index.jsp").forward(req, resp);
			}
			else
			{
				req.getRequestDispatcher("admin/LoginFail.jsp").forward(req, resp);
			}
			
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
