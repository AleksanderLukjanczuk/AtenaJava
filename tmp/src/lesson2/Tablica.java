package lesson2;

import java.util.Arrays;
import java.util.Random;

public class Tablica {

	public static void main(String[] args) {
		// simple();
		matrix();
	}

	public static void matrix() {
		int arr[][] = new int[10][10];
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				arr[x][y] = ((x == y || x + y == 9) ? 1 : 0);
			}
		}
		printArr(arr);
	}

	public static void printArr(int[][] arr) {
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr.length; x++) {
				System.out.printf("%2d", arr[y][x]);
			}
			System.out.println();
		}
	}

	public static void simple() {
		int[] dane = new int[10];
		int d = 10;
		for (int i = 0; i < 10; i++)
			dane[i] = --d;
		for (int i : dane)
			System.out.print(i);
		int[] dane2 = new int[10];
		System.out.println();

		Random rand = new Random();
		Arrays.setAll(dane2, i -> {
			return rand.nextInt(10);
		});
		System.out.println(Arrays.toString(dane2));
	}
}