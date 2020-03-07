package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class coinChange_done {
	static int[] intArray = null;
	static HashMap<String, Integer> memoryT = new HashMap<String, Integer>();

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(in);
		StringBuffer sb = new StringBuffer();
		String[] strArray = null;

		int N = 0;
		int T = 0;
		int sum = 0;
		try {
			T = Integer.parseInt(bf.readLine());
//			T = 1;
			while (T != 0) {
				N = Integer.parseInt(bf.readLine());
//				N = 3;
				intArray = new int[N];
				strArray = new String[N];
				String temp_line = bf.readLine();
//				String temp_line = "1 2 3";
//				System.out.println("coin array :: " + temp_line);
				strArray = temp_line.split(" ");
				for (int i = 0; i < strArray.length; i++) {
					intArray[i] = Integer.parseInt(strArray[i]);
				}
				Arrays.sort(intArray);
				sum = Integer.parseInt(bf.readLine());
//				sum = 4;
//				System.out.println("sum :: " + sum);
//				memoryT = new int[sum + 1];
//				for (int i = 0; i < memoryT.length; i++) {
//					memoryT[i] = -1;
//				}
				sb.append(solver(sum, intArray[intArray.length - 1]));
				if (T != 1) {
					sb.append("\n");
				}
				T--;
				memoryT = new HashMap<String, Integer>();
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int solver(int sum, int max_coin_to_be_used) {

		if (!memoryT.containsKey(sum + "_" + max_coin_to_be_used)) {
			if (sum == 0) {
//				System.out.println("calculated count: " + 1 + " for sum: " + sum);
				return 1;
			} else {
				int count = 0;
				for (int i = 0; i < intArray.length; i++) {

					if (intArray[i] <= sum && intArray[i] <= max_coin_to_be_used) {
//						System.out.println("x " + intArray[i] + " for sum " + sum);
						count += solver(sum - intArray[i], intArray[i]); // used coin intArray[i]
//						System.out.println("sum :: " + (sum - intArray[i]) + " :: count :: " + count);
					} else {
						break;
					}
				}
//				System.out.println("calculated count: " + count + " for sum: " + sum);
				memoryT.put(sum + "_" + max_coin_to_be_used, count);
				return count;
			}
		} else {
//			System.out.println("extracted count: " + memoryT.get(sum + "_" + max_coin_to_be_used)
//					+ " from memory at sum: " + sum + " and max_coin_to_be_used " + max_coin_to_be_used);
			return memoryT.get(sum + "_" + max_coin_to_be_used);
		}
	}
}
