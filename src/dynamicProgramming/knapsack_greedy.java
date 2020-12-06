package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class knapsack_greedy {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;
		int W = 0;
		Scanner in = new Scanner(System.in);
		String stringArray[] = null;
		String temp_line = null;
		int[] valueArray = null;
		int[] weightArray = null;
		float[] floatArray = null;
		HashMap<Float, Integer> hashmap_value = new HashMap<Float, Integer>();
		HashMap<Float, Integer> hashmap_weight = new HashMap<Float, Integer>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				N = Integer.parseInt(temp_line);
				temp_line = br.readLine();
				W = Integer.parseInt(temp_line);
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				valueArray = new int[N];
				weightArray = new int[N];
				floatArray = new float[N];
				for (int i = 0; i < stringArray.length; i++) {
					valueArray[i] = Integer.parseInt(stringArray[i]);
				}
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				for (int i = 0; i < stringArray.length; i++) {
					weightArray[i] = Integer.parseInt(stringArray[i]);
				}
				/*
				 * for (int i = 0; i < stringArray.length; i++) { System.out.print(valueArray[i]
				 * + " "); } System.out.println(); for (int i = 0; i < stringArray.length; i++)
				 * { System.out.print(weightArray[i] + " "); } System.out.println();
				 */
				for (int i = 0; i < stringArray.length; i++) {
					floatArray[i] = ((float) valueArray[i] / (float) weightArray[i]);
					hashmap_value.put(floatArray[i], valueArray[i]);
					hashmap_weight.put(floatArray[i], weightArray[i]);
				}
				/*
				 * for (int i = 0; i < floatArray.length; i++) {
				 * System.out.println(floatArray[i] + " "+valueArray[i]+" "+weightArray[i]); }
				 */
				Arrays.sort(floatArray);

				/*
				 * for (int i = 0; i < floatArray.length; i++) { System.out.print(floatArray[i]
				 * + " "+i); }
				 */

				int capacity = 0;
				int result_value = 0;
				for (int i = floatArray.length - 1; i >= 0; i--) {

					if ((capacity + hashmap_weight.get(floatArray[i])) <= W) {
						capacity += hashmap_weight.get(floatArray[i]);
						result_value += hashmap_value.get(floatArray[i]);
						/*
						 * System.out.println(hashmap_weight.get(floatArray[i]) + " " +
						 * hashmap_value.get(floatArray[i]) + " " + floatArray[i] + " :: capacity = " +
						 * capacity + " result_value = " + result_value);
						 */
					}
				}
				sb.append(result_value);
//				System.out.println("result value :: " + result_value);
//				knapSackSolver(valueArray, weightArray);
				if (T != 1) {
					sb.append("\n");
				}
				T--;
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
}
