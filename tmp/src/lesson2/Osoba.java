package lesson2;

public class Osoba extends People {

	private String imie;
	private String nazwisko;
	private int wiek;

	public class Plecak {
		public String marka;

		public Plecak(String marka) {
			this.marka = marka;
		}
	}

	public Osoba() {
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public Osoba(int wiek) {
		this.wiek = wiek;
	}

}
