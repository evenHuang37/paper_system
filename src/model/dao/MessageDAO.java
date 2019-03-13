package model.dao;

import java.util.List;

import model.vo.Message;

public interface MessageDAO {
	public boolean doCreate(Message messages)throws Exception;  
    public List<Message> findAll()throws Exception;  
    public Message findById(int messageID)throws Exception;
    public List<Message> findByReceiverId(String receiverID) throws Exception; 
    public List<Message> findBySenderId(String senderID) throws Exception; 

}
