package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Unfinished_Find_first_set_bit {
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
//			T = Integer.parseInt(bf.readLine());
			T = 2;
			while (T != 0) {
//				N = Integer.parseInt(bf.readLine());
//				N = 18;
				intArray = new int[N];
				strArray = new String[N];
				
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

	private static int solver(int sum, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
