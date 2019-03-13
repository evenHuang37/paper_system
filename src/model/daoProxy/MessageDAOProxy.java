package model.daoProxy;

import java.util.List;

import model.dao.MessageDAO;
import model.daoImpl.MessageDAOImpl;
import model.dbc.DatabaseConnection;
import model.vo.Message;

public class MessageDAOProxy implements MessageDAO
{
	private DatabaseConnection dbc=null;
	private MessageDAO dao=null;
	public MessageDAOProxy() throws Exception 
	{
		dbc=new DatabaseConnection();
		dao=new MessageDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Message message) throws Exception {
		boolean flag=dao.doCreate(message);
		return flag;
	}

	@Override
	public List<Message> findAll() throws Exception {
		List<Message> list=dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Message findById(int messageID) throws Exception {
		Message messages=null;
		messages=dao.findById(messageID);
		dbc.close();
		return messages;
	}
	
	public List<Message> findBySenderId(String senderID) throws Exception {
		List<Message> list=dao.findBySenderId(senderID);
		dbc.close();
		return list;
	}
	public List<Message> findByReceiverId(String receiverID) throws Exception{
		List<Message> list=dao.findByReceiverId(receiverID);
		dbc.close();
		return list;
	}

}
