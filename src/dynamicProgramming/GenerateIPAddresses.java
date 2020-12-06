package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class GenerateIPAddresses {
	static HashMap<String, Integer> memoryT = new HashMap<String, Integer>();

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(in);
		StringBuffer sb = new StringBuffer();
		int T = 0;
		try {
			T = Integer.parseInt(bf.readLine());
//			T = 1;
			while (T != 0) {
				String s = bf.readLine();
				ArrayList<String> vec = genIP2(s);
				for (int i = 0; i < vec.size(); i++) {
					sb.append(vec.get(i) + "\n");
				}
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

	static ArrayList<String> genIP(String s) {
		int len = s.length() - 1;
		ArrayList<String> vec = new ArrayList<String>();
		for (int i = 1; i <= len - 2; i++) {
			for (int j = i + 1; j <= len - 1; j++) {
				for (int k = j + 1; k <= len; k++) {
					int a = Integer.parseInt(s.substring(0, i));
					int b = Integer.parseInt(s.substring(i, j));
					int c = Integer.parseInt(s.substring(j, k));
					int d = Integer.parseInt(s.substring(k));
					if (______________ok(a, b, c, d)) {
						String str = ____________G(a, b, c, d);
						/* +3 because of 3 dots */
						if (str.length() == s.length() + 3) {
							vec.add(str);
						}
					}
					vec.add(a + "." + b + "." + c + "." + d);
				}
			}
		}
		return vec;
	}

	static ArrayList<String> genIP2(String s) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 3; k++) {
					for (int l = 1; l <= 3; l++) {
						if (i + j + k + l == s.length()) {
							int a = Integer.parseInt(s.substring(0, i));
							int b = Integer.parseInt(s.substring(i, i + j));
							int c = Integer.parseInt(s.substring(i + j, i + j + k));
							int d = Integer.parseInt(s.substring(i + j + k, i + j + k + l));
							if (______________ok(a, b, c, d)) {
								String str = ____________G(a, b, c, d);
								/* +3 because of 3 dots */
								if (str.length() == s.length() + 3) {
									res.add(str);
								}
							}
						}
					}
				}
			}
		}
		return res;
	}

	public static boolean ______________ok(int a, int b, int c, int d) {
		return a <= 255 && b <= 255 && c <= 255 && d <= 255;
	}

	public static String ____________G(int a, int b, int c, int d) {
		return String.valueOf(a) + "." + String.valueOf(b) + "." + String.valueOf(c) + "." + String.valueOf(d);
	}
}
