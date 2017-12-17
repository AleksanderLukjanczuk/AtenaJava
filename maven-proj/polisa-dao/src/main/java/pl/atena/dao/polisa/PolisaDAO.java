package pl.atena.dao.polisa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pl.atena.dao.connect.DBConnection;
import pl.atena.domain.Polisa;
import pl.atena.domain.PolisaFiltr;

public class PolisaDAO {

	public boolean create(Polisa polisa) throws SQLException {
		Connection con = DBConnection.get();
		PreparedStatement pstmt = con.prepareStatement(
				"insert into POLISA (nr_polisy, d_podpisania, d_rozpoczecia, d_konca, skladka) values (?,?,?,?,?)");
		pstmt.setString(1, polisa.getNrPolisy());
		pstmt.setDate(2, java.sql.Date.valueOf(polisa.getdPodpisania()));
		pstmt.setDate(3, java.sql.Date.valueOf(polisa.getdRozpoczecia()));
		pstmt.setDate(4, java.sql.Date.valueOf(polisa.getdKonca()));
		pstmt.setBigDecimal(5, polisa.getSkladka());

		int row = pstmt.executeUpdate();
		return row > 0 ? true : false;
	}

	public boolean update(Polisa polisa) {
		// TODO
		return true;
	}

	public boolean delete(Polisa polisa) {
		// TODO
		return true;
	}

	public List<Polisa> select(PolisaFiltr filtr) {
		// TODO
		return null;
	}

}
