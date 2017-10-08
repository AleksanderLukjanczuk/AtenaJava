package lesson2;

import java.util.Scanner;

public class StringFormat {

	public static void main(String[] args) {
		String text = "Hellow \n world!!";
		Scanner scanner = new Scanner(text);
		int arrSize = text.split("\n").length;
		for (int i = 0; i < arrSize; i++) {
			// System.out.println("Nowa linia - " + scanner.hasNext());
			System.out.format("[%d] Wczytuje:\t%s\n", i, scanner.nextLine().trim());
		}
		System.out.println("Ostatnia linia: " + !scanner.hasNext());
		scanner.close();
		
		System.out.printf("PI = %.5f", Math.PI);
	}
}
