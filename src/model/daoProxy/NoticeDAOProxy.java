package model.daoProxy;

import java.util.List;

import model.dao.NoticeDAO;
import model.daoImpl.NoticeDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Notice;

public class NoticeDAOProxy implements NoticeDAO
{
	private DatabaseConnection dbc=null;
	private NoticeDAO dao=null;
	public NoticeDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new NoticeDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Notice notice) throws Exception {
		boolean flag=false;
		flag=dao.doCreate(notice);
		dbc.close();
		return flag;
	}

	@Override
	public List<Notice> findAll() throws Exception {
		List<Notice> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Notice findById(int noticeID) throws Exception {
		Notice notice=null;
		notice=dao.findById(noticeID);
		dbc.close();
		return notice;
	}

	@Override
	public List<Notice> findByManagerID(String managerID) throws Exception {
		List<Notice> list=null;
		list=dao.findByManagerID(managerID);
		dbc.close();
		return list;
	}

}
