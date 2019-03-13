package model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.MessageDAO;
import model.vo.Message;

public class MessageDAOImpl implements MessageDAO{
	private Connection conn=null;
	private PreparedStatement stat=null;
	public MessageDAOImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Message messages) throws Exception {
		String sql="insert into message(senderID,receiverID,message,sendDate) values(?,?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, messages.getSenderID());
		stat.setString(2, messages.getReceiverID());
		stat.setString(3, messages.getMessage());
		stat.setString(4, messages.getSendDate());
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
	public List<Message> findAll() throws Exception {
		String sql="select* from message";
		stat=conn.prepareStatement(sql);
		ResultSet rs=stat.executeQuery();
		Message messages=null;
		List<Message> list=new ArrayList<Message>();
		while(rs.next())
		{
			int messageID=rs.getInt(1);
			String senderID=rs.getString(2);
			String receiverID=rs.getString(3);
			String message=rs.getString(4);
			String sendDate=rs.getString(5);
			messages=new Message();
			messages.setMessageID(messageID);
			messages.setSenderID(senderID);
			messages.setReceiverID(receiverID);
			messages.setMessage(message);
			messages.setSendDate(sendDate);
			list.add(messages);
		}
		return list;
	}

	@Override
	public Message findById(int messageID) throws Exception 
	{
		String sql="select * from message where messageID=?";
		stat=conn.prepareStatement(sql);
		stat.setInt(1, messageID);
		ResultSet rs=stat.executeQuery();
		Message messages=null;
		while(rs.next())
		{
			String senderID=rs.getString(2);
			String receiverID=rs.getString(3);
			String message=rs.getString(4);
			String sendDate=rs.getString(5);
			messages=new Message();
			messages.setMessageID(messageID);
			messages.setSenderID(senderID);
			messages.setReceiverID(receiverID);
			messages.setMessage(message);
			messages.setMessage(sendDate);
		}
		return messages;
	}
	
	public List<Message> findByReceiverId(String receiverID) throws Exception 
	{
		String sql="select * from message where ReceiverID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, receiverID);
		ResultSet rs=stat.executeQuery();
		Message messages=null;
		List<Message> list=new ArrayList<Message>();
		while(rs.next())
		{
			String senderID=rs.getString(2);
			int messageID=rs.getInt(1);
			String message=rs.getString(4);
			String sendDate=rs.getString(5);
			messages=new Message();
			messages.setMessageID(messageID);
			messages.setSenderID(senderID);
			messages.setReceiverID(receiverID);
			messages.setMessage(message);
			messages.setSendDate(sendDate);
			list.add(messages);
		}
		return list;
	}
	
	public List<Message> findBySenderId(String senderID) throws Exception 
	{
		String sql="select * from message where ReceiverID=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, senderID);
		ResultSet rs=stat.executeQuery();
		Message messages=null;
		List<Message> list=new ArrayList<Message>();
		while(rs.next())
		{
			String receiverID=rs.getString(3);
			int messageID=rs.getInt(1);
			String message=rs.getString(4);
			String sendDate=rs.getString(5);
			messages=new Message();
			messages.setMessageID(messageID);
			messages.setSenderID(senderID);
			messages.setReceiverID(receiverID);
			messages.setMessage(message);
			messages.setMessage(sendDate);
			list.add(messages);
		}
		return list;
	}
	
}
