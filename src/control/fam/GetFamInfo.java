package control.fam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.FamAction;
import model.vo.Facultymanagers;

public class GetFamInfo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FamAction famAction=new FamAction();
		String managerID=(String)req.getSession().getAttribute("userID");
		Facultymanagers fam=famAction.getInfo(managerID);
		String managerName=fam.getManagerName();
		String facultyName=famAction.getFacultyInfo(fam.getFacultyID()).getFacultyName();
		String email=fam.getEmail();
		String telephone=fam.getTelephone();
		req.setAttribute("name", managerName);
		req.setAttribute("managerID", managerID);
		req.setAttribute("facultyName", facultyName);
		req.setAttribute("email", email);
		req.setAttribute("telephone", telephone);
		req.getRequestDispatcher("admin/fm_info.jsp").forward(req, resp);
		
	}
}