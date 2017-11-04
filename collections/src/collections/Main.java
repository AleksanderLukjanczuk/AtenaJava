package collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	private static Map<String, Integer> words = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "D:\\Atena\\JavaAcademy\\AtenaJava\\collections\\src\\dok.txt";
		countWordsInFile(filePath);

		Stream<Map.Entry<String, Integer>> sorted = words.entrySet().stream().sorted(Map.Entry.comparingByValue());
		sorted.forEach(key -> System.out.printf("%10s\t%s\r\n", key.getKey(), key.getValue()));
	}

	public static void countWordsInFile(String filePath) throws FileNotFoundException {
		Scanner file = new Scanner(new File(filePath));
		while (file.hasNextLine()) {
			String[] line = file.nextLine().split(" ");
			Arrays.asList(line).forEach(str -> putToMap(str.trim()));
		}
		file.close();
	}

	private static void putToMap(String str) {
		str = (!str.isEmpty() && !str.startsWith("http")
				? str.replaceAll("[^a-zę€óąśłżźćńA-ZĘ€ÓĄŚŁŻŹĆŃ0-9]", "")
				: str.trim());
		if (str.isEmpty())
			return;
		if (words.containsKey(str)) {
			words.put(str, words.get(str) + 1);
		} else {
			words.put(str, 1);
		}
	}

	public void collections() {
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
