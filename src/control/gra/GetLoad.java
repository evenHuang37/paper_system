package control.gra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.fam.NoticeInfo;
import model.daoFactory.NoticeDAOFactory;
import model.vo.Notice;


public class GetLoad extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			List<Notice> notice=NoticeDAOFactory.getInstance().findAll();
			List<String> downloadList=new ArrayList<String>();
			for(int i=0;i<notice.size();i++)
			{
				String download=notice.get(i).getDownload();
				downloadList.add(download);
			}
			request.setAttribute("downloadList", downloadList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("admin/std_load.jsp").forward(request, response);
	}

}
