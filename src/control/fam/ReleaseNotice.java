package control.fam;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.action.FamAction;

public class ReleaseNotice extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
	    String managerID=(String)session.getAttribute("userID");
		String download=request.getParameter("download");
		System.out.println(download);
		String noticeTitle=request.getParameter("title");
	    String noticeContent=request.getParameter("content");		  
	    System.out.println(noticeTitle);
	    System.out.println(noticeContent);
	    Date now=new Date();
        DateFormat nowFormat=DateFormat.getDateTimeInstance();
        String noticedate=nowFormat.format(now);
        FamAction famAction=new FamAction();
        boolean flag=famAction.submitNotice(managerID, noticeTitle, noticeContent, noticedate, download);
        if(flag)
        {
        	request.setAttribute("upload.message", "发布公告成功！");
        }
        else{
        	request.setAttribute("upload.message", "发布公告失败！");
        }
        request.getRequestDispatcher("admin/uploadResult.jsp").forward(request, response);
	}

}
