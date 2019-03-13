package control.gra;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.GraAction;

public class Gramsg extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String senderID=(String)req.getSession().getAttribute("userID");
		GraAction graAction=new GraAction();
		String receiverID=graAction.getInfo(senderID).getTutorID();
		String msgContent=req.getParameter("content");
		System.out.println(msgContent);
		Date now=new Date();
		DateFormat nowFormat=DateFormat.getDateTimeInstance();
		String sendDate=nowFormat.format(now);
	    boolean flag=false;
	    String message1;
	    String message2;
	    if(!msgContent.equals(""))
	    {
	    	flag=graAction.saveMessage(senderID, receiverID, msgContent, sendDate);
		    if(flag)
		    {
		    	message1="¡Ù—‘≥…π¶£°";
		    }
		    else
		    {
		    	message1="¡Ù—‘ ß∞‹£°";
		    }
	    }
	    else
	    {
	    	message1="¡Ù—‘≤ªƒ‹Œ™ø’£°";
	    }
	    
	    req.setAttribute("message1", message1);
	    req.getRequestDispatcher("admin/message.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
