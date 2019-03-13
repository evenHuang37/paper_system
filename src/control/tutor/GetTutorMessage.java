package control.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.GraAction;
import model.action.TutorAction;


public class GetTutorMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TutorAction tuAction=new TutorAction();
		String tutorID=(String)request.getSession().getAttribute("userID");
		List<String> messageinfo=tuAction.getMessage(tutorID);
		int listnum=messageinfo.size();
		request.setAttribute("listnum", listnum);
		for(int i=0;i<listnum;i++)
		{
			System.out.println(messageinfo.get(i));
			request.setAttribute("message"+i, messageinfo.get(i));
		}
		request.getRequestDispatcher("admin/tutor_msglist.jsp").forward(request, response);
	}

}
