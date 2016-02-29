package Tables;

import java.sql.Timestamp;


public class bugticket {
	private     int ticketNo;
	private 	int userID;
	private 	String title;
	private 	String Description;
	private 	Timestamp createdDate;
	private 	Timestamp lastModified;
	
	public bugticket() {
		
	}
	
	public String[] getColumnNames() {
		String[] arrays = {"Ticket No", "User ID", "Title", "Description", "Date Created"} ;
		return arrays;		
	}
	
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getLastModified() {
		return lastModified;
	}
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	
	
	
}
