package model.vo;

public class Message {
	private int messageID;
	private String senderID;
	private String receiverID;
	private String message;
	private String sendDate;
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int massageID) {
		this.messageID = massageID;
	}
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public String getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
}
