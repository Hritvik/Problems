package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class subArrayProductLessThanK {
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
			T = 1;
			while (T != 0) {
				int[] intArray = null;
				strArray = new String[N];
				String temp_line = bf.readLine();
				strArray = temp_line.split(" ");
				N = Integer.parseInt(strArray[0]);
				sum = Integer.parseInt(strArray[1]);
				temp_line = bf.readLine();
				strArray = temp_line.split(" ");
				for (int i = 0; i < strArray.length; i++) {
					intArray[i] = Integer.parseInt(strArray[i]);
				}
				sum = Integer.parseInt(bf.readLine());
//				sb.append();
				if (T != 1) {
					sb.append("\n");
				}
				T--;
//				memoryT = new HashMap<String, Integer>();
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
