package pl.atena.dao.polisa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import pl.atena.core.BaseDao;
import pl.atena.core.connectors.DB;
import pl.atena.domain.polisa.Polisa;
import pl.atena.domain.polisa.PolisaFiltr;

public class PolisaDao implements BaseDao<Polisa, PolisaFiltr> {

	private Logger log = Logger.getLogger(PolisaDao.class.getCanonicalName());

	public void create(Polisa entity) throws SQLException {
		Connection c = DB.get();

		PreparedStatement ps = c.prepareStatement(
				"INSERT INTO POLISA(NR_POLISY, D_PODPISANIA, D_ROZPOCZECIA, D_KONCA, SKLADKA) VALUES (?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);

		ps.setString(1, entity.getNrPolisy());
		ps.setString(2, entity.getdPodpisania().format(DateTimeFormatter.ISO_LOCAL_DATE));
		ps.setString(3, entity.getdRozpoczecia().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		ps.setString(4, entity.getdKonca().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		ps.setBigDecimal(5, entity.getSkladka());
		int row = ps.executeUpdate();
		if (row > 0) {
			ResultSet rs = ps.getGeneratedKeys();
			entity.setId(rs.getLong(1));
		}
		log.info("Dodano " + row + " wierszy do tabeli POLISA: " + entity);
		c.close();
	}

	public Polisa retrieve(Long id) throws SQLException {
		Connection c = DB.get();
		PreparedStatement ps = c.prepareStatement(
				"Select NR_POLISY, D_PODPISANIA, D_ROZPOCZECIA, D_KONCA, SKLADKA FROM POLISA WHERE ID = ?");
		ps.setLong(1, id);
		ResultSet rset = ps.executeQuery();
		Polisa res;
		if (rset.next()) {
			res = new Polisa(id, rset.getString(1), LocalDate.parse(rset.getString(2)),
					LocalDateTime.parse(rset.getString(3)), LocalDateTime.parse(rset.getString(4)),
					rset.getBigDecimal(5));
		} else {
			res = null;
		}
		c.close();
		return res;
	}

	public boolean update(Polisa entity) throws SQLException {
		Connection c = DB.get();
		PreparedStatement ps = c.prepareStatement(
				"UPDATE POLISA SET NR_POLISY=?, D_PODPISANIA=?, D_ROZPOCZECIA=?, D_KONCA=?, SKLADKA=? WHERE ID=?");
		ps.setString(1, entity.getNrPolisy());
		ps.setString(2, entity.getdPodpisania().format(DateTimeFormatter.ISO_LOCAL_DATE));
		ps.setString(3, entity.getdRozpoczecia().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		ps.setString(4, entity.getdKonca().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		ps.setBigDecimal(5, entity.getSkladka());
		ps.setLong(6, entity.getId());
		int upCount = ps.executeUpdate();
		log.info("Onnowiono " + upCount + " wierszy w tabeli POLISA: " + entity);
		c.close();
		return (upCount == 1 ? true : false);
	}

	public boolean delete(Polisa entity) throws SQLException {
		boolean res = false;
		Connection c = DB.get();
		PreparedStatement ps = c.prepareStatement("DELETE FROM POLISA WHERE ID=?");
		ps.setLong(1, entity.getId());
		res = (ps.executeUpdate() == 0 ? false : true);
		c.close();
		return res;
	}

	@Override
	public List<Polisa> select(PolisaFiltr filter) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = DB.get();
		String where = "";

		if (filter != null && filter.getNrPolisy() != null && !filter.getNrPolisy().isEmpty()) {
			where = " WHERE NR_POLISY = " + filter.getNrPolisy();
		}

		PreparedStatement ps = c.prepareStatement(
				"Select ID, NR_POLISY, D_PODPISANIA, D_ROZPOCZECIA, D_KONCA, SKLADKA FROM POLISA" + where);
		ResultSet rset = ps.executeQuery();
		List<Polisa> res = new ArrayList<>();
		while (rset.next()) {
			res.add(new Polisa(rset.getLong(1), rset.getString(2), LocalDate.parse(rset.getString(3)),
					LocalDateTime.parse(rset.getString(4)), LocalDateTime.parse(rset.getString(5)),
					rset.getBigDecimal(6)));
		}
		c.close();
		return res;
	}
}
