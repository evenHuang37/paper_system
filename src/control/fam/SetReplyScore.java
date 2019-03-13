package control.fam;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.FamAction;
import model.action.GraAction;

public class SetReplyScore extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	String managerID="001";
	FamAction famAction=new FamAction();
	String facilityID=famAction.getInfo(managerID).getFacultyID();
	String graID1=req.getParameter("stuID1");
	String graReplyScore1=req.getParameter("relpyScore1");
	double gRScore1 =Double.parseDouble(graReplyScore1);
	String graID2=req.getParameter("stuID2");
	String graReplyScore2=req.getParameter("relpyScore2");
	double gRScore2 =Double.parseDouble(graReplyScore2);
	String graID3=req.getParameter("stuID3");
	String graReplyScore3=req.getParameter("relpyScore3");
	double gRScore3 =Double.parseDouble(graReplyScore3);
	String graID4=req.getParameter("stuID4");
	String graReplyScore4=req.getParameter("relpyScore4");
	double gRScore4 =Double.parseDouble(graReplyScore4);
	boolean flag1,flag2,flag3,flag4=false;
    String message1;
    String message2;
    flag1=famAction.submitReplyscore(graID1, gRScore1);
    flag2=famAction.submitReplyscore(graID2, gRScore2);
    flag3=famAction.submitReplyscore(graID3, gRScore3);
    flag4=famAction.submitReplyscore(graID4, gRScore4);
    if(flag1&&flag2&&flag3&&flag4)
    {
    	message1="答辩成绩保存成功！";
    	message2="再次存储成绩！";
    }
    else
    {
    	message1="答辩成绩保存失败！";
    	message2="请再次保存！";
    }
    req.setAttribute("message1", message1);
    req.setAttribute("message2", message2);
    req.getRequestDispatcher("fam_successSaveScore.jsp").forward(req, resp);
		}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}
