package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objects.Apple;
import objects.Biedronka;
import objects.Cigarettes;
import objects.Goods;
import objects.Milk;
import objects.Orange;
import objects.PersonPrivate;
import objects.Piwo;
import objects.Zabka;

public class Test {

	public static void main(String[] args) {
		List<PersonPrivate> persons = new ArrayList<>();
		persons.add(new PersonPrivate("Aleks", "Wajda", 22));
		persons.add(new PersonPrivate("Wojtek", "Kruchy", 48));
		persons.add(new PersonPrivate("Tomek", "Rudy", 36));

		List<PersonPrivate> youngPersons = new ArrayList<>();
		youngPersons.add(new PersonPrivate("Jhon", "Wajda", 14));
		youngPersons.add(new PersonPrivate("Den", "Kruchy", 10));

		List<Goods> shopStore = addGoodToShopStorage();
		Zabka zabka = new Zabka();
		zabka.addGoods(shopStore);
		zabka.setPromcja(promotion());

		persons.forEach(person -> zabka.sellGoods(generateAgeGood(5, false), person));

		zabka.printStorageGoods();

		System.out.println();
		System.out.println();
		List<Goods> shopStoreB = addGoodToShopStorage();
		Biedronka biedra = new Biedronka();
		biedra.addGoods(shopStoreB);
		biedra.setPromcja(promotion());
		youngPersons.forEach(person -> biedra.sellGoods(generateAgeGood(10, false), person));
		biedra.printStorageGoods();
	}

	private static List<Goods> addGoodToShopStorage() {
		List<Goods> shopStore = new ArrayList<>();
		// shopStore.add(new Apple(generator(20), generator(10)));
		shopStore.add(new Cigarettes(generator(20), generatorB(10)));
		shopStore.add(new Milk(generator(20), generatorB(10)));
		shopStore.add(new Orange(generator(20), generatorB(10)));
		shopStore.add(new Piwo(generator(20), generatorB(10)));
		return shopStore;
	}

	private static List<Goods> promotion() {
		Random rand = new Random();
		List<Goods> res = new ArrayList<>();
		res.add(new Orange(1, BigDecimal.valueOf(rand.nextFloat())));
		return res;
	}

	private static List<Goods> generateAgeGood(Integer bound, Boolean checkAge) {
		List<Goods> res = new ArrayList<>();
		if (!checkAge) {
			res.add(new Piwo(generator(bound), generatorB(10)));
			res.add(new Cigarettes(generator(bound), generatorB(10)));
		}
		res.add(new Apple(generator(bound), generatorB(10)));
		res.add(new Milk(generator(bound), generatorB(10)));
		res.add(new Orange(generator(bound), generatorB(10)));
		return res;
	}

	private static BigDecimal generatorB(int bound) {
		Random rand = new Random();
		BigDecimal res = BigDecimal.valueOf(0);
		while (res.equals(BigDecimal.ZERO)) {
			res = BigDecimal.valueOf(rand.nextInt(bound));
		}
		return res;
	}

	private static Integer generator(Integer bound) {
		Random rand = new Random();
		Integer res = 0;
		while (!(res > 0)) {
			res = rand.nextInt(bound);
		}
		return res;
	}
}