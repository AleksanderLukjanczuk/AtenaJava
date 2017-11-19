package objects;

public class AgeException extends Exception {
	private static final long serialVersionUID = 3349793669892926131L;

	public AgeException() {
		super("Osoba jest nie pełnoletnia!");
	}

	public AgeException(Person person, Goods good) {
		super("Osoba jest nie pełnoletnia! Nie moge sprzedać: " + good.name() + ", " + person.toString());
	}
}
