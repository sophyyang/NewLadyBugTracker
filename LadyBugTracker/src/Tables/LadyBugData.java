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

public class LadyBugData {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	ArrayList<user> arrayList = new ArrayList<user>();

 	
	public LadyBugData( ) throws SQLException {
		
//		try {
			makeConnection();
			String q = "select * from user";
			st = con.createStatement();
			rs = st.executeQuery(q);
			System.out.println("start....");
			while(rs.next()) {
				Tables.user u = new Tables.user();
				u.setUserID(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.seteMailAdd(rs.getString(4));
				u.setRoleID(rs.getInt(5));
				u.setCreatedDate(rs.getDate(6));
				u.setLastModified(rs.getDate(7));				
				arrayList.add(u);				
			}
			System.out.println(arrayList);

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		
//		} catch (SQLException e) {
//			System.out.println("Error with table or data");
//		}
		
		
	}
	
	
	
	
	
	
	
	
	

	public void makeConnection() {
		String url = "jdbc:mysql://localhost/ladybugtracker";
		String password = "syang11";
		String user = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");

		} catch (Exception ex) {
			Logger lgr = Logger.getLogger(LadyBugData.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			System.out.println("Sql Exception");

		}

	}
}