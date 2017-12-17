package pl.atena.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Polisa {
	private Integer id;
	private String nrPolisy;
	private LocalDate dPodpisania;
	private LocalDate dRozpoczecia;
	private LocalDate dKonca;
	private BigDecimal skladka;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNrPolisy() {
		return nrPolisy;
	}

	public void setNrPolisy(String nrPolisy) {
		this.nrPolisy = nrPolisy;
	}

	public LocalDate getdPodpisania() {
		return dPodpisania;
	}

	public void setdPodpisania(LocalDate dPodpisania) {
		this.dPodpisania = dPodpisania;
	}

	public LocalDate getdRozpoczecia() {
		return dRozpoczecia;
	}

	public void setdRozpoczecia(LocalDate dRozpoczecia) {
		this.dRozpoczecia = dRozpoczecia;
	}

	public LocalDate getdKonca() {
		return dKonca;
	}

	public void setdKonca(LocalDate dKonca) {
		this.dKonca = dKonca;
	}

	public BigDecimal getSkladka() {
		return skladka;
	}

	public void setSkladka(BigDecimal skladka) {
		this.skladka = skladka;
	}

	@Override
	public String toString() {
		return String.format("Polisa [id=%s, nrPolisy=%s, dPodpisania=%s, dRozpoczecia=%s, dKonca=%s, skladka=%s]", id,
				nrPolisy, dPodpisania, dRozpoczecia, dKonca, skladka);
	}
}
