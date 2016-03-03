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
	private  	String title;
	private 	Timestamp createdDate;
	private  	String priority;
	private 	String status;
	private  	String role;
 	

	public ladybugdetail() {
		
	}
	
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String[] getColumnNames() {
		//String[] arrays = {"Ticket No", "Requester","Priority", "Status", "Role", "Title", "Description", "Request Date", "Assignee", "Detail Description"} ;
		String[] arrays = {"Ticket No", "Requester", "Title", "Detail Description", "Assignee", "Request Date"} ;
		return arrays;		
	}
	
	public String reauesterFullName() {
		return this.requesterFirstName + " " + this.requesterLastName;
	}

	public String assigneeFullName() {
		return this.assigneeFirstName + " " + this.assigneeLastName;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	
	
	
}
