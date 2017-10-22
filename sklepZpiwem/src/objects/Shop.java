package objects;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private final String NAME = "Lidl ;)";
	private List<Goods> storage = new ArrayList<>();
	private Boolean canToSell;

	public Shop() {
		printStorageGoods();
	}

	public void addGoods(List<Goods> goods) {
		goods.forEach(obj -> {
			if (storage.contains(obj)) {
				Goods towar = storage.get(storage.indexOf(obj));
				towar.setCount(towar.getCount() + obj.getCount());
			} else {
				storage.add(obj);
			}
			System.out.printf("Do sklepu dodano %d %s \t %d zł\n", obj.getCount(), obj.name(), obj.getPrice());
		});
	}

	public void printStorageGoods() {
		System.out.printf("Witamy w sklepie '%s'\n", NAME);
		System.out.println("===========================");
		this.storage.forEach(good -> System.out.printf("W sklepie zostało: %d\t%s\t%d zł\n", good.getCount(),
				good.name(), good.getPrice()));
	}

	public void sellGoods(List<Goods> goods, PersonPrivate person) {
		System.out.printf("%s kupił:\n", person.getName());
		goods.forEach(obj -> {
			if (storage.contains(obj)) {
				if (isCanToSell(obj, person)) {
					Goods towar = storage.get(storage.indexOf(obj));
					towar.setCount(towar.getCount() - obj.getCount());
					System.out.printf("%d %s\n", obj.getCount(), obj.name());
				}
			} else {
				System.err.printf(
						"Drogi kliencie %s nie mogę sprzedać ci %s ponieważ nie mamy go w sklepie\n",
						person.getName(), obj.name());
			}
		});
		System.out.println();
	}

	public boolean isCanToSell(Goods good, PersonPrivate person) {
		this.canToSell = true;
		if (person == null) {
			System.out.println("ERROR: person object is null!!!");
			return false;
		}
		if (good.checkAge() && !checkAge(person)) {
			System.err.printf("Drogi kliencie %s nie mogę sprzedać ci %s ponieważ masz %d lat\n", person.getName(),
					good.name(), person.getAge());
			this.canToSell = false;
			return false;
		}
		Goods objInStorage = storage.get(storage.indexOf(good));
		if (checkCountToSell(objInStorage.getCount(), good.getCount()) < 0) {
			System.err.printf("Drogi kliencie %s nie mogę sprzedać ci %s ponieważ chcesz kupić %d, a my mamy %d\n",
					person.getName(), good.name(), good.getCount(), objInStorage.getCount());
			this.canToSell = false;
			return false;
		}
		return this.canToSell;
	}

	public boolean checkAge(PersonPrivate person) {
		if (person == null || person.getAge() < 18) {
			return false;
		}
		return true;
	}

	public Integer checkCountToSell(Integer countInShoop, Integer countForBuy) {
		return (countInShoop - countForBuy);
	}

	public String getName() {
		return NAME;
	}

	public List<Goods> getStorage() {
		return storage;
	}

	public void setStorage(List<Goods> storage) {
		this.storage = storage;
	}
}
