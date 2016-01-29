package Tables;

import java.sql.Timestamp;

public class ladybugdetail {
	private 	int ticketNo;
	private 	String requesterFirstName;
	private 	String requesterLastName;
	private  	int priorityID;
	private 	int statusID;
	private  	int roleID;
	private  	String Description;
	private 	Timestamp requestDate;
	private 	String assigneeFirstName;
	private 	String assigneeLastName;
	private 	String detailDescription;
	private 	Timestamp lastModified;
	
	public ladybugdetail() {
		
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getRequesterFirstName() {
		return requesterFirstName;
	}
	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}
	public String getRequesterLastName() {
		return requesterLastName;
	}
	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}
	public int getPriorityID() {
		return priorityID;
	}
	public void setPriorityID(int priorityID) {
		this.priorityID = priorityID;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Timestamp getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
	public String getAssigneeFirstName() {
		return assigneeFirstName;
	}
	public void setAssigneeFirstName(String assigneeFirstName) {
		this.assigneeFirstName = assigneeFirstName;
	}
	public String getAssigneeLastName() {
		return assigneeLastName;
	}
	public void setAssigneeLastName(String assigneeLastName) {
		this.assigneeLastName = assigneeLastName;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public Timestamp getLastModified() {
		return lastModified;
	}
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	
	
	
}
