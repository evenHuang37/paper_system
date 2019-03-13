package control.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.TutorAction;
import model.vo.Graduates;

public class TutorToMsg extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String tutorID=(String)req.getSession().getAttribute("userID");
		TutorAction tutorAction=new TutorAction();
		List<Graduates> graduates=tutorAction.getGraduates(tutorID);
		req.setAttribute("graduates", graduates);
		req.getRequestDispatcher("admin/tutor_msg.jsp").forward(req, resp);
	}
}
