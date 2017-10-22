package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Towar> towary = new ArrayList<>();
		towary.add(new Towar("Apple", 10));
		towary.add(new Towar("Orange", 1));
		towary.add(new Towar("Juce", 22));
		towary.add(new Towar("Jua", 20));
		towary.add(new Towar("Melon", 20));
		towary.add(new Towar("Apple", 12));
		
		System.out.println("Before sort: ");
		towary.forEach(System.out::println);
		
		Collections.sort(towary);
		
		System.out.println("After sort: ");
		towary.forEach(System.out::println);
	}
}
