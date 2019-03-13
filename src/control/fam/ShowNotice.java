package control.fam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.daoFactory.NoticeDAOFactory;
import model.daoImpl.NoticeDAOImpl;
import model.vo.Notice;


public class ShowNotice extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			List<Notice> notice=NoticeDAOFactory.getInstance().findAll();
			List<NoticeInfo> noticeList=new ArrayList<NoticeInfo>();
			for(int i=0;i<notice.size();i++)
			{
				String noticeTitle=notice.get(i).getNoticetitle();
				String noticeDate=notice.get(i).getNoticedate();
				String noticeContent=notice.get(i).getNoticehref(); 
				NoticeInfo noticeInfo=new NoticeInfo();
				noticeInfo.setNoticeTitle(noticeTitle);
				noticeInfo.setNoticeDate(noticeDate);
				noticeInfo.setNoticeContent(noticeContent);
				noticeList.add(noticeInfo);
			}
			request.setAttribute("noticeList", noticeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("admin/notice.jsp").forward(request, response);
	}

}
