package dynamicProgramming;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Scanner;

public class BadNeighborsNearComplete {
	public static int[] donations = null;
	public static HashMap<String, Integer> memoryT = new HashMap<String, Integer>();

	public static void main(String[] args) {
		BufferedReader br = null;
		Scanner in = null;
		try {
//			in = new Scanner(System.in);
//			br = new BufferedReader(new InputStreamReader(System.in));
//			String temp = br.readLine();
//			String temp = "10 3 2 5 7 8";
//			String temp = "7, 7, 7, 7, 7, 7, 7";
//			String temp = "1, 2, 3, 4, 5, 1, 2, 3, 4, 5";
//			String temp = "94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72";
			String temp = "11, 15";
			String[] tempArray = temp.split(", ");
			donations = new int[tempArray.length];
			for (int i = 0; i < tempArray.length; i++) {
				donations[i] = Integer.parseInt(tempArray[i]);
			}
			System.out.print("Array :: ");
			for (int i = 0; i < donations.length; i++) {
				System.out.print(donations[i] + " ");
			}
			System.out.println();

			System.out.println(recursiveMethod(0, 0));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				br.close();
//				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	static int recursiveMethod(int start, int endIncluded) {
		System.out.println(donations[start] + " {--------------------");
		if (memoryT.containsKey(start + "#" + endIncluded)) {
//			System.out.println("extracted :: " + start + "#" + endIncluded);
			System.out.println("--------------------} " + donations[start]);
			return memoryT.get(start + "#" + endIncluded);
		} else {
			int max = donations[start];
			int N = donations.length;
			if (endIncluded == 0) {
				N = donations.length - 1;
			}
			for (int i = start; i < N; i++) {
				if (start == 0 && i == 1) {
					endIncluded = 1;
				}

				int temp = 0;
				if (((endIncluded == 1) && (i + 2) < donations.length)
						|| ((endIncluded == 0) && ((i + 2) < (donations.length - 1)))) {
					temp = donations[i] + recursiveMethod(i + 2, endIncluded);
				}

				if (temp > max) {
					max = temp;
					System.out.println("selected :: " + donations[i]);
					System.out.println("new max = " + max);
				}
			}
//			System.out.println("inserted :: " + start + "#" + endIncluded + " :: " + max);
			memoryT.put(start + "#" + endIncluded, max);
			System.out.println("returning " + max);
			System.out.println("--------------------} " + donations[start]);
			return max;
		}
	}
}
