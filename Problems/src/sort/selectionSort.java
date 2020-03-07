package sort;

import java.util.Scanner;

public class selectionSort {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int T = Integer.parseInt(sc.nextLine());
			while (T-- > 0) {
				int N = Integer.parseInt(sc.nextLine());
				String[] temp = sc.nextLine().split(" ");
				int[] arr = new int[N];
				for (int i = 0; i < N; i++) {
					arr[i] = Integer.parseInt(temp[i]);
					
				}
				sort(arr);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = 99999;
			int minIndex = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
}
