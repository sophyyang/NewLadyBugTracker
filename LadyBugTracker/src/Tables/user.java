package Tables;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class user {
	private int userID;
	private String firstName;
	private String lastName;
	private String eMailAdd;
	private int roleID;
	private Timestamp createdDate;
	private Timestamp lastModified;
	private final int statusNo = 1;
	private final int roleNo = 2;
	private final int priorityNo = 3;


//	public user(int userID, String firstName, String lastName, String eMailAdd, int roleID, Timestamp createdDate,
//			Timestamp lastModified) {
//		this.setUserID(userID);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.seteMailAdd(eMailAdd);
//		this.setRoleID(roleID);
//		this.setCreatedDate(createdDate);
//		this.setLastModified(lastModified);
//
//	}

	public String[] getColumnNames() {
		String[] arrays = {"ID", "First Name", "Last Name" , "eMail" , " Role", "Created Date", "Last Modified Date"} ;
		return arrays;
	}

	public String getRoleDescription() {
		String desc = "";
		try {
			LadyBugData rsList = new LadyBugData();
			desc=	rsList.GetItemsList(" = " + roleNo + " AND ID = " + getRoleID()).get(0).getDescription();	
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		return desc;
	}
	
	public String getRoleDescription(int input) {
		String desc = "";
		try {
			LadyBugData rsList = new LadyBugData();
			desc=	rsList.GetItemsList(" = " + roleNo + " AND ID = " + input).get(0).getDescription();	
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		return desc;
	}
	
	
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
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

	@Override
	public String toString() {
		return "user [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", eMailAdd="
				+ eMailAdd + ", roleID=" + roleID + ", createdDate=" + createdDate + ", lastModified=" + lastModified
				+ ", roleDescription=" + getRoleDescription() + "]";
	}

}
