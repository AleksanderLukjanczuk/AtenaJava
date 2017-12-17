package pl.atena.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con = null;

	public DBConnection() {
	}

	public static Connection get() {
		if (con == null) {
			con = create();
		}
		return con;
	}

	private static Connection create() {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:mydatabase", "SA", "");
			if (con != null) {
				System.out.println("Connection created successfully");
			} else {
				throw new SQLException("Problem with creating connection");
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return con;
	}
}
