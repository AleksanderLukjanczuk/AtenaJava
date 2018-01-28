package pl.atena.dao.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pl.atena.core.connectors.DB;
import pl.atena.dao.polisa.PolisaDao;
import pl.atena.domain.polisa.Polisa;
import pl.atena.domain.polisa.PolisaFiltr;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PolisaDaoTest {

	private PolisaDao dao;
	private static Polisa polisa;
	private static String policyNumber = "";
	private static PolisaFiltr filter;

	@BeforeClass
	public static void runOnceBeforeClass() throws SQLException {
		DB.get();
		policyNumber = Long.toString(Math.round(Math.random() * 10000));
		filter = new PolisaFiltr(policyNumber);
		polisa = new Polisa();
		polisa.setNrPolisy(policyNumber);
		polisa.setdPodpisania(LocalDate.now());
		polisa.setdRozpoczecia(LocalDateTime.now());
		polisa.setdKonca(LocalDateTime.now().plusYears(1));
		polisa.setSkladka(BigDecimal.valueOf(463.45));
	}

	@AfterClass
	public static void runOnceAfterClass() throws SQLException {
		DB.close();
	}

	@Before
	public void runOnceBeforeTestMethod() {
		dao = new PolisaDao();
	}

	@Test
	public void test1Create() throws SQLException {
		dao.create(polisa);
		assertTrue(polisa.getId() != null);
		assertThat(polisa.getId().intValue(), greaterThan(0));
	}

	@Test(expected = SQLException.class)
	public void test2CreateException() throws SQLException {
		Polisa polisa2 = new Polisa();
		polisa2.setdPodpisania(LocalDate.now());
		polisa2.setdRozpoczecia(LocalDateTime.now());
		polisa2.setdKonca(LocalDateTime.now().plusYears(1));
		dao.create(polisa2);
	}

	@Test
	public void test3Retrieve() throws SQLException {
		polisa = dao.retrieve(polisa.getId());
		assertEquals(polisa.getNrPolisy(), policyNumber);
	}

	@Test
	public void test4Update() throws SQLException {
		polisa.setSkladka(BigDecimal.valueOf(111.11));
		assertTrue(dao.update(polisa));
		assertEquals(polisa.getSkladka(), BigDecimal.valueOf(111.11));
	}

	@Test
	public void test5SelectOne() throws SQLException {
		assertTrue(dao.select(filter).size() == 1);
		assertTrue(dao.select(null).size() > 1);
	}

	// @Ignore
	@Test
	public void test7Delete() throws SQLException {
		dao.delete(polisa);
		assertNull(dao.retrieve(polisa.getId()));
	}

}
