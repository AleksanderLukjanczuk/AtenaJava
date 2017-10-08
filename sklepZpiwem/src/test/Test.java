package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objects.Person;
import objects.Shop;

public class Test {

	public static void main(String[] args) {
		Random rand = new Random();
		Shop shop = new Shop();
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Aleks", "Wajda", 22));
		persons.add(new Person("Wojtek", "Kruchy", 18));
		persons.add(new Person("Tomek", "Rudy", 16));

		shop.addBeer(rand.nextInt(20));
		shop.sellBeer(persons.get(0));

		for (Person person : persons) {
			shop.sellBeer(person, rand.nextInt(10));
		}

		shop.sellBeer(persons.get(1), 15);

		shop.showBeerCount();
		for (Person person : persons) {
			System.out.printf("%s kupił %d\n", person.getName(), person.getBeerBought());
		}
	}

}
