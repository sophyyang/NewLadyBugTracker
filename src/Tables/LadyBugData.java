/**
 * 
 * Author Sophy Yang
 * Date January 22, 2016
 *
 */
package Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class LadyBugData {
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	private final String userSqlStr = "SELECT * FROM user";
	private final String dropdownItemStr = "SELECT * FROM dropdownitems";
	private final String itemsSqlStr = "SELECT dropdownitems.ID AS ID, " + "dropdownitems.Description AS Description, "
			+ "dropdownlist.Description AS iClass, " + "dropdownitems.iOrder AS iOrder, "
			+ "dropdownitems.dropdownListID AS dropdownListID " + " FROM " + "(dropdownitems  JOIN dropdownlist ON "
			+ "((dropdownitems.DropdownListID = dropdownlist.DropdownListID))) " + " WHERE "
			+ " (dropdownitems.DropdownListID  ";
	private final String ticketSqlStr = "SELECT * FROM ladybugdetail";

	// ArrayList<ItemList> arrayList = new ArrayList<ItemList>();
	//
	// public LadyBugData() {
	//
	// }

	public String DateToString(Timestamp t) {
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		DateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
		DateFormat df4 = new SimpleDateFormat("MM dd, yyyy");
		DateFormat df5 = new SimpleDateFormat("E, MMM dd yyyy");
		DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

		String out = df2.format(t);

		return out;
	}

	public String currentDateTimeToString() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return now.toString();
	}

	public void makeConnection() {
		String url = "jdbc:mysql://localhost/ladybugtracker";
		String password = "password";
		String user = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			// System.out.println("Connection made");

		} catch (Exception ex) {
			Logger lgr = Logger.getLogger(LadyBugData.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			System.out.println("Sql Exception");

		}

	}
	
	public Object[] buildDropDownArray(int input) {
		return buildDropDownArray1(input, 0);
	}

	public Object[] buildDropDownArray1(int input, int start) {
		Object[] outArray = null;
		try {
			outArray = new String[this.LadyBugItems(input).size() + start] ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			outArray[0] = "List All";
			for (int r = start; r < (this.LadyBugItems(input).size() + start); r++) {
				outArray[r] = this.LadyBugItems(input).get(r-start).getDescription();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outArray;
	}

	public Object[] buildUserDropDownArray() {
		return buildUserDropDownArray1(0);
	}

	public Object[] buildUserDropDownArray1(int start) {
		Object[] outArray = null;
		outArray = new String[this.LadyBugUser().size() + start] ;
		outArray[0] = "List All";
		for (int r = start; r < (this.LadyBugUser().size() + start) ; r++) {
			outArray[r] = this.LadyBugUser().get(r-start).getFirstName() + " " + this.LadyBugUser().get(r-start).getLastName();
		}
		return outArray;
	}

	public ArrayList<user> LadyBugUser() {
		return getUserList(" ");
	}

	public ArrayList<user> LadyBugUser(String ID) {
		String sqlWhereStr = " WHERE UserID = " + ID;
		return getUserList(sqlWhereStr);
	}

	public ArrayList<user> getUserList(String sqlWhereStr) {
		ArrayList<user> arrayList = new ArrayList<user>();
		try {
			makeConnection();
			String q = userSqlStr;
			st = con.createStatement();
			rs = st.executeQuery(q + sqlWhereStr);
			while (rs.next()) {
				Tables.user u = new Tables.user();
				u.setUserID(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.seteMailAdd(rs.getString(4));
				u.setRoleID(rs.getInt(5)); // rs.getInt(5)
				Timestamp times = rs.getTimestamp(6);
				u.setCreatedDate(times);
				times = rs.getTimestamp(7);
				u.setLastModified(times);
				// u.getRoleDescription();
				u.getRoleDescription(rs.getInt(5));
				arrayList.add(u);
			}

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("1Error with table or data");
		}

		return arrayList;
	}

	public ArrayList<ItemList> LadyBugItems() throws SQLException {
		return GetItemsList(" >= 0 ");
	}

	public ArrayList<ItemList> LadyBugItems(int inputType) throws SQLException {
		return GetItemsList(" = " + inputType);
	}

	public ArrayList<ItemList> LadyBugItems(String inputType) throws SQLException {
		int results = 2;
		switch (inputType.toUpperCase()) {
		case "STATUS":
			results = 1;
			break;
		case "ROLE":
			results = 2;
			break;
		case "PRIORITY":
			results = 3;
			break;

		}
		return GetItemsList(" = " + results);
	}

	public ArrayList<ItemList> LadyBugItems(int inputType, String inputID) throws SQLException {
		return GetItemsList(" = " + inputType + " AND ID = " + inputID);
	}

	public ArrayList<ItemList> LadyBugItems(String inputType, String inputID) {
		int results = 2;
		switch (inputType.toUpperCase()) {
		case "STATUS":
			results = 1;
			break;
		case "ROLE":
			results = 2;
			break;
		case "PRIORITY":
			results = 3;
			break;

		}
		return GetItemsList(" = " + results + " AND ID = " + inputID);
	}

	public ArrayList<ItemList> GetItemsList(String inputType) {
		ArrayList<ItemList> arrayList = new ArrayList<ItemList>();
		try {
			makeConnection();
			String q = itemsSqlStr + inputType + ") ORDER BY dropdownListID, iOrder";
			st = con.createStatement();
			rs = st.executeQuery(q);
			while (rs.next()) {
				Tables.ItemList items = new Tables.ItemList();
				items.setID(rs.getInt("ID"));
				items.setDescription(rs.getString("Description"));
				items.setiClass(rs.getString("iClass"));
				items.setiOrder(rs.getInt("iOrder"));
				items.setDropdownListID(rs.getInt("dropdownListID"));
				arrayList.add(items);
			}

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("2Error with table or data");
		}

		return arrayList;
	}

	public ArrayList<dropdownitems> LadyBugDropDownList() {
		return LadyBugDropDownList("none");
	}

	public ArrayList<dropdownitems> LadyBugDropDownList(String ID) {
		ArrayList<dropdownitems> arrayList = new ArrayList<dropdownitems>();
		try {

			String whereSQLstr = "";
			if (!ID.equals("none")) {
				whereSQLstr = " WHERE ( ID =" + ID + ") ORDER BY iOrder";
			}
			makeConnection();
			String q = dropdownItemStr;
			st = con.createStatement();
			rs = st.executeQuery(q + whereSQLstr);
			while (rs.next()) {
				Tables.dropdownitems items = new Tables.dropdownitems();
				items.setID(rs.getInt("ID"));
				items.setDropdownListID(rs.getInt("DropdownListID"));
				items.setDescription(rs.getString("Description"));
				items.setiOrder(rs.getInt("iOrder"));
				Timestamp times = rs.getTimestamp("DateCreated");
				items.setCreatedDate(times);
				times = rs.getTimestamp("LastModified");
				items.setLastModified(times);
				arrayList.add(items);
			}

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("3Error with table or data");
		}

		return arrayList;
	}

	public void updateItemOrder(ItemList i) {
		makeConnection();
		try {
			String q = "UPDATE dropdownitems SET ";
			q += " iOrder = ";
			q += i.getiOrder() + ", ";
			q += " LastModified = NOW() ";
			q += " WHERE ID = " + i.getID();
			st = con.createStatement();
			st.executeUpdate(q);
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("4Error with table or data");
		}

	}

	public void insertNewItem(ItemList i) {
		makeConnection();
		try {
			String q = "insert into dropdownitems";
			q += "( DropdownListID, Description, iOrder )";
			q += " values (";
			q += i.getDropdownListID() + ", ";
			q += "'" + i.getDescription() + "', ";
			q += i.getiOrder();
			q += ")";
			st = con.createStatement();
			st.executeUpdate(q);

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("5Error with table or data");
		}

	}

	public void deleteItem(ItemList i) {
		makeConnection();
		try {
			String q = "delete dropdownitems where ID = " + i.getID();
			st = con.createStatement();
			st.executeUpdate(q);

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("6Error with table or data");
		}

	}

	public void updateUser(user i) {
		makeConnection();
		try {
			String q = "UPDATE user SET ";
			q += " FirstName = '" + i.getFirstName().trim() + "', ";
			q += " LastName = '" + i.getLastName().trim() + "', ";
			q += " eMailAdd = '" + i.geteMailAdd() + "', ";
			q += " RoleID = " + i.getRoleID() + ", ";
			q += " LastModified = NOW() ";
			q += " WHERE UserID = " + i.getUserID();
			st = con.createStatement();
			st.executeUpdate(q);
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("7Error with table or data");
		}

	}

	public void insertNewUser(user i) {
		makeConnection();
		try {
			String q = "insert into user";
			q += "( FirstName, LastName, eMailAdd, RoleID )";
			q += " values ('";
			q += i.getFirstName() + "', '";
			q += i.getLastName() + "', ";
			q += "'" + i.geteMailAdd() + "', ";
			q += i.getRoleID();
			q += ")";
			st = con.createStatement();
			st.executeUpdate(q);

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("8Error with table or data");
		}

	}

	public void deleteUser(user i) {
		makeConnection();
		try {
			String q = "delete FROM ladybugtracker.user where UserID = " + i.getUserID();
			st = con.createStatement();
			st.executeUpdate(q);

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("9Error with table or data " + e.getMessage());
		}

	}

	// * UPDATE BUGTICKET TABLE FROM BUGTICKETPANEL - MARY
	public int insertNewTicket(int u, String t, String d) {
		makeConnection();
		int key = 0;
		try {
			String q = "INSERT INTO bugticket (UserID, Title, Description, CreatedDate) VALUES " + "('" + u + "', '" + t
					+ "', '" + d + "', " + "NOW());";
			System.out.println(q);

			st = con.createStatement();
			st.executeUpdate(q, st.RETURN_GENERATED_KEYS);
			
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
			}
			
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("Error with bugticket table or data" + e.getMessage());
		}
		return key;
	}

	// * UPDATE HISTORY TABLE FROM BUGTICKETPANEL - MARY
	public void insertNewHistory(int key, int u, int s, int p, String d) {
		makeConnection();
		try {
			String q = "INSERT INTO history (TicketNo, UserID, StatusID, PriorityID, Description, CreatedDate) VALUES "
					+ "('" + key + "', '" + u + "', '" + s + "', '" + p + "', '" + d + "', " + "NOW());";
			System.out.println(q);
		
			st = con.createStatement();
			st.executeUpdate(q);

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println();
			System.out.println("Error with history table or data" + e.getMessage());
		}
	}

	// * QUERY user TABLE FOR User ID - MARY
	public int selectUser(String f, String l) {
		makeConnection();
		int tempNo = 0;
		try {
			String q = "SELECT UserId FROM user WHERE FirstName = '" + f + "' and LastName = '" + l + "';";
			st = con.createStatement();
			rs = st.executeQuery(q);
			System.out.println("userid="+tempNo+" sql="+q);

			while (rs.next()) {
				tempNo = rs.getInt("UserId");
			}
			
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Error with user table or data" + e.getMessage());
		}
		return tempNo;
	}

	// * QUERY status TABLE FOR status ID - MARY
	public int selectStatus(String s) {
		makeConnection();
		int tempNo = 0;
		try {
			String q = "SELECT ID FROM status WHERE Description = " + "'" + s + "';";
			st = con.createStatement();
			rs = st.executeQuery(q);

			while (rs.next()) {
				tempNo = rs.getInt("ID");
			}

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("Error with status table or data" + e.getMessage());
		}
		return tempNo;
	}

	// * QUERY priority TABLE FOR priority ID - MARY
	public int selectPriority(String p) {
		makeConnection();
		int tempNo = 0;
		try {
			String q = "SELECT ID FROM priority WHERE Description = " + "'" + p + "';";
			st = con.createStatement();
			rs = st.executeQuery(q);

			while (rs.next()) {
				tempNo = rs.getInt("ID");
			}

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("Error with priority table or data" + e.getMessage());
		}
		return tempNo;
	}

	
	public ArrayList<ladybugdetail> LadyBugTicket() {
		return getLadyBugTicket(" ");
	}

	public ArrayList<ladybugdetail> LadyBugTicket(String ID) {
		String sqlWhereStr = " WHERE TicketNo = " + ID;
		return getLadyBugTicket(sqlWhereStr);
	}

	public ArrayList<ladybugdetail> getLadyBugTicket(String sqlWhereStr) {
		ArrayList<ladybugdetail> arrayList = new ArrayList<ladybugdetail>();
		try {
			makeConnection();
			String q = ticketSqlStr;
			st = con.createStatement();
			if (sqlWhereStr.equals("List All")) {
				sqlWhereStr ="";
			}
			rs = st.executeQuery(q + sqlWhereStr);
			while (rs.next()) {
				Tables.ladybugdetail ticket = new Tables.ladybugdetail();
				ticket.setTicketNo(rs.getInt(1));
				ticket.setRequesterFirstName(rs.getString(2));
				ticket.setRequesterLastName(rs.getString(3));
				ticket.setPriority(rs.getString(4));
				ticket.setStatus(rs.getString(5));
				ticket.setRole(rs.getString(6));
				ticket.setTitle(rs.getString(7));
				ticket.setDescription(rs.getString(8));
				Timestamp times = rs.getTimestamp(9);				
				ticket.setRequestDate(times);
				ticket.setAssigneeFirstName(rs.getString(10));
				ticket.setAssigneeLastName(rs.getString(11));
				ticket.setDetailDescription(rs.getString(12));
				times = rs.getTimestamp(13);
				ticket.setCreatedDate(times);
				arrayList.add(ticket);
			}

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("0Error with table or data");
		}

		return arrayList;
	}


} // end