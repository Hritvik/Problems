package dynamicProgramming;
import java.util.HashMap;
import java.util.Scanner;

public class BooleanParenthesization_Solved {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int T = Integer.parseInt(sc.nextLine());
			while (T-- > 0) {
				int N = Integer.parseInt(sc.nextLine());
				String str = sc.nextLine();
				HashMap<String, long[]> memory = new HashMap<String, long[]>();
				long[] result = solveStr(str, memory);
				System.out.println(result[0] % 1003);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	private static long[] solveStr(String str, HashMap<String, long[]> memory) {
//		System.out.println(str);
		if (memory.containsKey(str)) {
			return memory.get(str);
		} else {
			long[] res = new long[2];
			if (str.equals("T")) {
				res[0] = 1;
			} else if (str.equals("F")) {
				res[1] = 1;
			} else {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '&' || str.charAt(i) == '|' || str.charAt(i) == '^') {
						String a = str.substring(0, i);
						String b = str.substring(i + 1);
						long[] res_a = solveStr(a, memory);
						long[] res_b = solveStr(b, memory);
//						System.out.println(
//								a + " = " + res_a[0] + ", " + res_a[1] + " :: " + b + " = " + res_b[0] + ", " + res_b[1]);
						long[] temp = evaluate(res_a, res_b, str.charAt(i));
						res[0] += temp[0];
						res[1] += temp[1];
					}
				}
			}
			memory.put(str, res);
			return res;
		}
	}

	private static long[] evaluate(long[] res_a, long[] res_b, char operator) {
		long[] res = new long[2];
		switch (operator) {
		case '&':
			res[0] = res_a[0] * res_b[0];
			res[1] = res_a[0] * res_b[1] + res_a[1] * res_b[0] + res_a[1] * res_b[1];
			break;
		case '|':
			res[0] = res_a[0] * res_b[1] + res_a[1] * res_b[0] + res_a[0] * res_b[0];
			res[1] = res_a[1] * res_b[1];
			break;
		case '^':
			res[0] = res_a[0] * res_b[1] + res_a[1] * res_b[0];
			res[1] = res_a[1] * res_b[1] + res_a[0] * res_b[0];
			break;
		}

//		System.out.println(res_a[0] + " :: " + res_a[1] + " :::: " + res_b[0] + " :: " + res_b[1] + " :::: " + operator
//				+ " ==> " + res[0] + " :: " + res[1]);
		return res;
	}
}
