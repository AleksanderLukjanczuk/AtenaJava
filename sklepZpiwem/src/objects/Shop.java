package objects;

public class Shop {
	private final String NAME = "Lidl ;)";
	private Integer beer = Integer.valueOf(0);

	public Shop() {
		System.out.printf("Witamy w sklepie '%s'\n", NAME);
		System.out.println("===========================");
	}

	public void addBeer(Integer count) {
		this.beer += count;
		System.out.printf("Do sklepu dodano %d piwa\n", count);
	}

	public void showBeerCount() {
		System.out.printf("W sklepie zostało %d piwa\n", this.beer);
	}

	public void sellBeer(Person person) {
		sellBeer(person, 1);
	}

	public void sellBeer(Person person, int beerCount) {
		if (person == null) {
			System.out.println("ERROR: person object is null!!!");
			return;
		}
		if (!checkAge(person)) {
			System.err.printf("Drogi kliencie %s nie mogę sprzedać ci piwa ponieważ masz %d lat\n", person.getName(),
					person.getAge());
			return;
		}
		if (!checkBeerToSell(beerCount)) {
			System.err.printf("Drogi kliencie %s nie mogę sprzedać ci piwa ponieważ chcesz kupić %d, a my mamy %d\n",
					person.getName(), beerCount, beer);
			return;
		}
		this.beer -= beerCount;
		person.addBeer(beerCount);
		System.out.printf("Sprzedano %d piwa dla %s\n", beerCount, person.getName());
	}

	public boolean checkAge(Person person) {
		if (person == null || person.getAge() < 18) {
			return false;
		}
		return true;
	}

	public boolean checkBeerToSell(Integer count) {
		if (count != null) {
			if (this.beer - count >= 0) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return NAME;
	}
}
