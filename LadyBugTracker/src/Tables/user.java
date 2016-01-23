package Tables;

import java.sql.Date;

public class user extends role{
	private 	int userID;
	private 	String firstName;
	private 	String lastName;
	private 	String eMailAdd;
	//private 	int roleID;
	private 	Date createdDate;
	private 	Date lastModified;
	
	public user(){
		
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMailAdd() {
		return eMailAdd;
	}
	public void seteMailAdd(String eMailAdd) {
		this.eMailAdd = eMailAdd;
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
