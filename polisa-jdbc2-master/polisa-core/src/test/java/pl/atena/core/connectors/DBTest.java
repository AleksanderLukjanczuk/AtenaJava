package pl.atena.core.connectors;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

public class DBTest extends TestCase {

	public void testGet() throws SQLException {
		Connection conn = DB.get();
		assertNotNull(conn);
	}

}
