package control.gra;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.FamAction;
import model.action.GraAction;
import model.action.TutorAction;
import model.vo.Graduates;

public class GetInfo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GraAction grAction=new GraAction();
		TutorAction tutorAction=new TutorAction();
		FamAction famAction=new FamAction();
		String stuID=(String)req.getSession().getAttribute("userID");
		Graduates graduate=grAction.getInfo(stuID);
		String name=graduate.getStuName();
		String facultyName=famAction.getFacultyInfo(graduate.getFacultyID()).getFacultyName();
		String className=graduate.getClassname();
		String year=graduate.getYear();
		String tutorName=tutorAction.getInfo(graduate.getTutorID()).getTutorName();
		req.setAttribute("name", name);
		req.setAttribute("stuID", stuID);
		req.setAttribute("facultyName", facultyName);
		req.setAttribute("className", className);
		req.setAttribute("year", year);
		req.setAttribute("tutorName", tutorName);
		req.getRequestDispatcher("admin/std_info.jsp").forward(req, resp);
		
	}
}
