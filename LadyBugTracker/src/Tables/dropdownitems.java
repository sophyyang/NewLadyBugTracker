package Tables;

 
import java.sql.Timestamp;

public class dropdownitems extends dropdownlist {
	private 	int ID;
	//private 	int dropdownListID;
	private 	String description;
	private 	int iOrder;
	private 	Timestamp createdDate;
	private 	Timestamp lastModified;
	
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
