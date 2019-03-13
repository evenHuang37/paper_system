package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.NoticeDAO;
import model.vo.Notice;

public class NoticeDAOImpl implements NoticeDAO{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public NoticeDAOImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Notice notice) throws Exception {
		String sql="insert into notice(managerID,noticetitle,noticehref,noticedate,download) values(?,?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, notice.getManagerID());
		stat.setString(2, notice.getNoticetitle());
		stat.setString(3, notice.getNoticehref());
		stat.setString(4, notice.getNoticedate());
		stat.setString(5, notice.getDownload());
		int update=stat.executeUpdate();
		if(update>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Notice> findAll() throws Exception {
		String sql="select * from notice";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Notice notice=null;
		List<Notice> list=new ArrayList<Notice>();
		while(rs.next())
		{
			int noticeID=rs.getInt(1);
			String managerID=rs.getString(2);
			String noticetitle=rs.getString(3);
			String noticehref=rs.getString(4);
			String noticedate=rs.getString(5);
			String download=rs.getString(6);
			notice=new Notice();
			notice.setNoticeID(noticeID);
			notice.setManagerID(managerID);
			notice.setNoticetitle(noticetitle);
			notice.setNoticehref(noticehref);
			notice.setNoticedate(noticedate);
			notice.setDownload(download);
			list.add(notice);
		}
		return list;
	}

	@Override
	public Notice findById(int noticeID) throws Exception 
	{
		String sql="select * from notice where noticeID=?";
		stat=conn.prepareStatement(sql);
		stat.setInt(1, noticeID);
		ResultSet rs=stat.executeQuery();
		Notice notice=null;
		while(rs.next())
		{
			String managerID=rs.getString(2);
			String noticetitle=rs.getString(3);
			String noticehref=rs.getString(4);
			String noticedate=rs.getString(5);
			String download=rs.getString(6);
			notice=new Notice();
			notice.setManagerID(managerID);
			notice.setNoticetitle(noticetitle);
			notice.setNoticehref(noticehref);
			notice.setNoticedate(noticedate);
			notice.setDownload(download);
		}
		return notice;
	}
	@Override
	public List<Notice> findByManagerID(String managerID) throws Exception {
		String sql="select * from notice where managerID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, managerID);
		ResultSet rs=stat.executeQuery();
		Notice notice=null;
		List<Notice> list=new ArrayList<Notice>();
		while(rs.next())
		{
			int noticeID=rs.getInt(1);
			String noticetitle=rs.getString(3);
			String noticehref=rs.getString(4);
			String noticedate=rs.getString(5);
			String download=rs.getString(6);
			notice=new Notice();
			notice.setNoticeID(noticeID);
			notice.setManagerID(managerID);
			notice.setNoticetitle(noticetitle);
			notice.setNoticehref(noticehref);
			notice.setNoticedate(noticedate);
			notice.setDownload(download);
			list.add(notice);
		}
		return list;
	}
	
}
