package Tables;

import java.sql.Timestamp;

public class history {
	private 	int historyID;
	private 	int ticketNo;
	private 	int userID;
	private 	int statusID;
	private 	int priorityID;
	private 	String description;
	private 	Timestamp lastModified;
	
	public history () {
		
	}
	public String[] getColumnNames() {
		String[] arrays = {"History ID", "Ticket No", "User", "Status", "Priority", "Description", "Date Created"} ;
		return arrays;		
	}

	public int getHistoryID() {
		return historyID;
	}
	public void setHistoryID(int historyID) {
		this.historyID = historyID;
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
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public int getPriorityID() {
		return priorityID;
	}
	public void setPriorityID(int priorityID) {
		this.priorityID = priorityID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getLastModified() {
		return lastModified;
	}
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	
	

}
