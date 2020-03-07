package kadane;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;

public class attempt2_kadane {
	static int[] intArray;
	static HashMap<String, Long> memoryT = new HashMap<String, Long>();

	public static void main(String[] args) {
		InputStream is = null;
		int N = 0;
		int T = 0;
		try {
			double startTime = (new Date()).getTime();
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

				sb.append(solver());
				if (T != 1) {
					sb.append("\n");
				}
				T--;
				memoryT = new HashMap<String, Long>();
			}
			System.out.println(sb);
			bf.close();
			double endTime = (new Date()).getTime();
			double duration = endTime - startTime;
			System.out.println("duration = " + duration);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static long solver() {
		long max = -999999999;
		boolean negFlag = true;
		long max_so_far = 0;
		long max_right_here = 0;

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] > max) {
				max = intArray[i];
			}
			if (intArray[i] >= 0) {
				negFlag = false;
			}
			max_right_here = max_right_here + intArray[i];
			if (max_right_here < 0) {
				max_right_here = 0;
			}
			if (max_so_far < max_right_here) {
				max_so_far = max_right_here;
			}
		}
		if (negFlag) {
			return max;
		}
		return max_so_far;
	}

}
