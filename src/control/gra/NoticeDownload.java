package control.gra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoticeDownload extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     request.setCharacterEncoding("UTF-8");
				String fname = request.getParameter("filename"); 
				 String filename=new String(fname.getBytes("ISO-8859-1"),"UTF-8");
			        System.out.println(filename);            
			        //设置文件MIME类型  
			        response.setContentType(getServletContext().getMimeType(filename));  
			        //设置Content-Disposition  
			        response.setHeader("Content-Disposition", "attachment;filename="+filename);  
			        //读取目标文件，通过response将目标文件写到客户端  
			        //获取目标文件的绝对路径  
			        String fullFileName = getServletContext().getRealPath("/WEB-INF/downloads/" + filename);  
			        //System.out.println(fullFileName);  
			        //读取文件  
			        InputStream in = new FileInputStream(fullFileName);  
			        OutputStream out = response.getOutputStream();  
			          
			        //写文件  
			        int b;  
			        while((b=in.read())!= -1)  
			        {  
			            out.write(b);  
			        }  
			          
			        in.close();  
			        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	}

}
