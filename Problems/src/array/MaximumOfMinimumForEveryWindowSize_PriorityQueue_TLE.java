package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MaximumOfMinimumForEveryWindowSize_PriorityQueue_TLE {

	public static void main(String[] args) {
		int T = 0;
		String stringArray[] = null;
		String temp_line = null;
		int intArray[] = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				intArray = new int[stringArray.length];
				for (int i = 0; i < stringArray.length; i++) {
					intArray[i] = Integer.parseInt(stringArray[i]);
				}
				arraySolver(intArray);
				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void arraySolver(int[] arr) {

		for (int i = 1; i <= arr.length; i++) {
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for (int j = 0; j < i; j++) {
				q.add(arr[j]);
			}
			int max = q.peek();
			for (int j = i; j < arr.length; j++) {
				q.remove(arr[j - i]);
				q.add(arr[j]);
				if (q.peek() > max) {
					max = q.peek();
				}
			}
			System.out.print(max);
			if (i < arr.length) {
				System.out.print(" ");
			}
		}
	}

}
