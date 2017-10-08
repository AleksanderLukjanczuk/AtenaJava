package lesson2;

import java.util.Random;

public class Pentla {

	public static void main(String arg[]) {
		// petlaWhile();
		// petlaDoWhile();
		petlaFor();
	}

	public static void petlaFor() {
		for (char i = 65; i <= 90; i++) {
			System.out.printf("%s ", i);
		}
		System.out.println();

		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (i == 0) {
					System.out.printf("[%2d]", j);
				} else if (j == 0) {
					System.out.printf("[%2d]", i);
				} else {
					System.out.printf("%4d", i * j);
				}
			}
			System.out.println();
		}
	}

	public static void petlaWhile() {
		Integer sum = Integer.valueOf(0);
		int finish = 100, iter = 1;
		while (iter <= finish) {
			sum += (++iter % 2 > 0 ? 0 : iter);
		}
		System.out.printf("Iter: %d, summa: %d", iter, sum);
	}

	public static void petlaDoWhile() {
		Integer max = null, min = null, aver = 0;
		int n = 5, r = 0;
		Integer sum = 0;
		Random rand = new Random();
		do {
			r = rand.nextInt(100);
			max = (max == null ? r : Math.max(r, max));
			min = (min == null ? r : Math.min(r, min));
			sum += r;
			n--;
		} while (n > 0);
		aver = sum / 5;
		System.out.printf("[%d] Max=%d, Min=%d, Average=%d", n, max, min, aver);
	}
}
