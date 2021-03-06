package objects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public abstract class Shop {
	private String name = "sklep no name";
	private List<Goods> storage = new ArrayList<>();
	private List<Goods> promcja = new ArrayList<>();
	private Boolean canToSell;

	public Shop(String name) {
		this.name = name;
		printStorageGoods();
	}

	public UnaryOperator<BigDecimal> modify() {
		int month = LocalDate.now().getMonthValue();
		if (month % 2 == 0) {
			return item -> item.multiply(BigDecimal.valueOf(0.9));
		} else {
			return item -> item.multiply(BigDecimal.valueOf(1.05));
		}
	}

	public void addGoods(List<Goods> goods) {
		goods.forEach(obj -> {
			if (storage.contains(obj)) {
				Goods towar = storage.get(storage.indexOf(obj));
				towar.setCount(towar.getCount() + obj.getCount());
				towar.setPrice(modify().apply(towar.getPrice()));
			} else {
				storage.add(obj);
			}
			System.out.printf("Do sklepu dodano %d %s \t %.2f zł\r\n", obj.getCount(), obj.name(), obj.getPrice());
		});
		System.out.println("=======================================");
		System.out.println();
	}

	public void printStorageGoods() {
		System.out.printf("Witamy w sklepie '%s'\r\n", this.name);
		System.out.println("=======================================");
		this.storage.forEach(good -> System.out.printf("W sklepie zostało: %d\t%s\t%.2f zł\r\n", good.getCount(),
				good.name(), good.getPrice()));
		if (this.storage.size() > 0)
			System.out.println("=======================================");
	}

	abstract BigDecimal promocja(Goods good);;

	public void sellGoods(List<Goods> goods, PersonPrivate person) {
		System.out.printf("%s kupił:\n", person.getName());
		goods.forEach(obj -> {
			if (storage.contains(obj)) {
				try {
					if (isCanToSell(obj, person)) {
						Goods towar = storage.get(storage.indexOf(obj));
						obj.setPrice(promocja(towar));
						towar.setCount(towar.getCount() - obj.getCount());
						System.out.printf("\t%d %s %.2f zł\r\n", obj.getCount(), obj.name(), obj.getPrice());
					}
				} catch (AgeException e) {
					// e.printStackTrace();
					System.out.println(e.getLocalizedMessage());
				}
			} else {
				System.err.printf("\tDrogi kliencie %s nie mogę sprzedać ci %s ponieważ nie mamy go w sklepie\r\n",
						person.getName(), obj.name());
			}
		});
		System.out.println();
	}

	public boolean isCanToSell(Goods good, PersonPrivate person) throws AgeException {
		this.canToSell = true;
		if (person == null) {
			System.out.println("ERROR: person object is null!!!");
			return false;
		}

		CheckAge age = good.getClass().getAnnotation(CheckAge.class);
		if (age != null && !checkAge(person, age.age())) {
			this.canToSell = false;
			throw new AgeException(person, good);
			// return false;
		}

		Goods objInStorage = storage.get(storage.indexOf(good));
		if (checkCountToSell(objInStorage.getCount(), good.getCount()) < 0) {
			System.err.printf("\tDrogi kliencie %s nie mogę sprzedać ci %s ponieważ chcesz kupić %d, a my mamy %d\r\n",
					person.getName(), good.name(), good.getCount(), objInStorage.getCount());
			this.canToSell = false;
			return false;
		}
		return this.canToSell;
	}

	public boolean checkAge(PersonPrivate person, int age) {
		if (person == null || person.getAge() < age) {
			return false;
		}
		return true;
	}

	public Integer checkCountToSell(Integer countInShoop, Integer countForBuy) {
		return (countInShoop - countForBuy);
	}

	public List<Goods> getStorage() {
		return storage;
	}

	public void setStorage(List<Goods> storage) {
		this.storage = storage;
	}

	public List<Goods> getPromcja() {
		return promcja;
	}

	public void setPromcja(List<Goods> promcja) {
		this.promcja = promcja;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
