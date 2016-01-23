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
import java.util.logging.Level;
import java.util.logging.Logger;

public class LadyBugData {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public LadyBugData() {

	}
	
	public LadyBugData(String tableName) {
		
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