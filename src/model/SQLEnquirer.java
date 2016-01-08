package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLEnquirer {

	private int deviceId;

	public SQLEnquirer(int deviceId) {
		this.deviceId = deviceId;
	}

	public ResultSet getRows() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://devweb2015.cis.strath.ac.uk/rmb12174",
					"rmb12174", "bareproo");
			Statement query = conn.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM Notes");
			// ResultSet result = query
			// .executeQuery("SELECT * FROM Notes WHERE D_id =" + deviceId);
			// change U_id in Notes to D_id as makes more sense
			while (result.next()) {
				String N_id = result.getString("N_id");
				System.out.println(N_id);
			}
			return result;
		} catch (SQLException se) {
			System.err.println("SQLException in SQLEnquirer; Error connecting to database.");
			se.printStackTrace();
		}
		return null;

	}

}
