package Tables;

import java.sql.Date;

public class dropdownitems extends dropdownlist {
	private 	int ID;
	//private 	int dropdownListID;
	private 	String description;
	private 	int iOrder;
	private 	Date createdDate;
	private 	Date lastModified;
	
	public dropdownitems() {
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getiOrder() {
		return iOrder;
	}
	public void setiOrder(int iOrder) {
		this.iOrder = iOrder;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	
	

}
