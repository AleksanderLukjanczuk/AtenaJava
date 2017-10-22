package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objects.Apple;
import objects.Cigarettes;
import objects.Goods;
import objects.Milk;
import objects.Orange;
import objects.PersonPrivate;
import objects.Piwo;
import objects.Shop;

public class Test {

	public static void main(String[] args) {
		Shop shop = new Shop();
		List<PersonPrivate> persons = new ArrayList<>();
		persons.add(new PersonPrivate("Aleks", "Wajda", 22));
		persons.add(new PersonPrivate("Wojtek", "Kruchy", 48));
		persons.add(new PersonPrivate("Tomek", "Rudy", 36));

		List<PersonPrivate> youngPersons = new ArrayList<>();
		youngPersons.add(new PersonPrivate("Jhon", "Wajda", 14));
		youngPersons.add(new PersonPrivate("Den", "Kruchy", 10));

		List<Goods> shopStore = new ArrayList<>();
//		shopStore.add(new Apple(generator(20), generator(10)));
		shopStore.add(new Cigarettes(generator(20), generator(10)));
		shopStore.add(new Milk(generator(20), generator(10)));
		shopStore.add(new Orange(generator(20), generator(10)));
		shopStore.add(new Piwo(generator(20), generator(10)));

		shop.addGoods(shopStore);

		persons.forEach(person -> shop.sellGoods(generateAgeGood(5, false), person));
		youngPersons.forEach(person -> shop.sellGoods(generateAgeGood(10, false), person));

		shop.printStorageGoods();
	}

	private static List<Goods> generateAgeGood(Integer bound, Boolean checkAge) {
		List<Goods> res = new ArrayList<>();
		if (!checkAge) {
			res.add(new Piwo(generator(bound), generator(10)));
			res.add(new Cigarettes(generator(bound), generator(10)));
		}
		res.add(new Apple(generator(bound), generator(10)));
		res.add(new Milk(generator(bound), generator(10)));
		res.add(new Orange(generator(bound), generator(10)));
		return res;
	}

	private static Integer generator(Integer bound) {
		Random rand = new Random();
		Integer res = 0;
		while (res <= 0) {
			res = rand.nextInt(bound);
		}
		return res;
	}
}