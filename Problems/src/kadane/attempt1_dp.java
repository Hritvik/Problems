package kadane;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class attempt1_dp {
	static int[] intArray;
	static HashMap<String, Long> memoryT = new HashMap<String, Long>();

	public static void main(String[] args) {
		InputStream is = null;
		int N = 0;
		int T = 0;
		try {
//			is = System.in;
			is = new FileInputStream("Kadane/0.txt");
			InputStreamReader in = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(in);
			StringBuffer sb = new StringBuffer();
			String[] strArray = null;
			T = Integer.parseInt(bf.readLine());
			while (T != 0) {
				N = Integer.parseInt(bf.readLine());
				intArray = new int[N];
				strArray = bf.readLine().split(" ");
//				System.out.print("****************");
				for (int i = 0; i < strArray.length; i++) {
					intArray[i] = Integer.parseInt(strArray[i]);
//					System.out.print(intArray[i] + " ");
				}
//				System.out.println("****************");
				long max = -999999999;
				for (int i = 0; i < intArray.length; i++) {
					long temp = solver(i, intArray.length);
					if (temp > max) {
						max = temp;
					}
				}
				sb.append(max);
				if (T != 1) {
					sb.append("\n");
				}
				T--;
				memoryT = new HashMap<String, Long>();
			}
			System.out.println(sb);
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static long solver(int start, int end) {
//		System.out.println("start = " + start + " , end = " + end);
		if (memoryT.containsKey(start + "#" + end)) {
			long max = memoryT.get(start + "#" + end);
//			System.out.println("a :: " + start + " " + end + " :: " + max);
			return max;
		} else {
			if (start == intArray.length) {
				return 0;
			} else {
				if (start == end) {
					long max = intArray[start];
//					System.out.println("b :: " + start + " " + end + " :: " + max);
					memoryT.put(start + "#" + end, max);
					return max;
				} else {
					long max = -999999999;
					long temp = intArray[start];
//					System.out.println(start + " -> " + start + " :: temp = " + temp);
					for (int i = start; i <= end; i++) {
						if (i >= start + 1) {
							temp = intArray[start] + solver(start + 1, i);
						} else {
							temp = intArray[start];
						}
//						System.out.println(start + 1 + " -> " + i + " :: temp = " + temp);
						if (temp > max) {
							max = temp;
						}
					}
//					System.out.println("c :: " + start + " " + end + " :: max = " + max);
					memoryT.put(start + "#" + end, max);
					return max;

				}
			}
		}
	}

	private static void solver2(int start, int end) {
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i; j < intArray.length; j++) {

			}
		}
	}
}
