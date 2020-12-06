package array;

import java.util.ArrayList;
import java.util.Scanner;

public class Working_subarrayWithGivenSum {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;
		int S = 0;

		Scanner in = new Scanner(System.in);
		String inputrArray[] = null;
		String temp_line = null;
		String[] tempArray = null;
		ArrayList<Long> intArray = new ArrayList<Long>();

		try {
			T = Integer.parseInt(in.nextLine());
			while (T != 0) {
				temp_line = in.nextLine();
				tempArray = temp_line.split(" ");

				N = Integer.parseInt(tempArray[0]);
				S = Integer.parseInt(tempArray[1]);
				temp_line = in.nextLine();
				inputrArray = temp_line.split(" ");
				intArray.clear();
				for (int i = 0; i < inputrArray.length; i++) {
					intArray.add(Long.parseLong(inputrArray[i]));
				}
				arraysolver(intArray, S);
				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	private static void arraysolver(ArrayList<Long> intArray, int S) {
		int startIndex = 0;
		int endIndex = 1;
		long sum = intArray.get(startIndex) + intArray.get(endIndex);
		while ((sum != S)&&(startIndex<intArray.size())) {
			if (endIndex != intArray.size() - 1) {
				if (sum < S) {
					endIndex++;
					sum = sum + intArray.get(endIndex);
				} else {
					sum = sum - intArray.get(startIndex);
					startIndex++;
				}
			} else {
				sum = sum - intArray.get(startIndex);
				startIndex++;
			}
		}
		startIndex++;
		endIndex++;
		if(sum == S){
		    System.out.println(startIndex + " " + endIndex);
		}
		else{
		    System.out.println("-1");
		}
	}

}
