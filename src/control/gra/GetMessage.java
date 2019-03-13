package control.gra;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.GraAction;


public class GetMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		GraAction grAction=new GraAction();
		String stuID=(String)request.getSession().getAttribute("userID");
		List<String> messageinfo=grAction.getMessage(stuID);
		int listnum=messageinfo.size();
		request.setAttribute("listnum", listnum);
		System.out.println("hjkkk");
		for(int i=0;i<listnum;i++)
		{
			System.out.println(messageinfo.get(i));
			request.setAttribute("message"+i, messageinfo.get(i));
		}
		request.getRequestDispatcher("admin/std_msglist.jsp").forward(request, response);
	}
}
