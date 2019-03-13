package control.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.Main;

import model.action.FamAction;
import model.action.TutorAction;
import model.vo.Tutors;

public class GetTutorInfo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TutorAction tuAction=new TutorAction();
		FamAction famAction=new FamAction();
		String tutorID=(String)req.getSession().getAttribute("userID");
		Tutors tutor=tuAction.getInfo(tutorID);
		String name=tutor.getTutorName();
	    String facultyName=famAction.getFacultyInfo(tutor.getFacultyID()).getFacultyName();
		String profession=tutor.getProfession();
		req.setAttribute("name", name);
		req.setAttribute("tutorID", tutorID);
		req.setAttribute("facultyName", facultyName);
		req.setAttribute("profession", profession);
		req.getRequestDispatcher("admin/tutor_info.jsp").forward(req, resp);
	}
	
}
