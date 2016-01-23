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
	//private String roleDescription;


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

	public String getRoleDescription() {
		String desc = "";
		try {
			LadyBugData rsList = new LadyBugData();

			for (int i = 0; i < (rsList.LadyBugDropDownList().size() - 1); i++) {
				if (rsList.LadyBugDropDownList().get(i).getID() == getRoleID()) {
					desc = rsList.LadyBugDropDownList().get(i).getDescription();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error with table or data");
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
