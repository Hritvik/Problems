package dynamicProgramming;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;

public class DistinctPalindromicSubstrings {
	static int count = 0;
	static int[][] mem = null;
	static HashSet<String> distinctPalindromes = null;

	public static void main(String[] args) {

		InputStream is = null;
		Scanner scanner = null;
		try {
			is = System.in;
//			is = new FileInputStream("FloydWarshall/0.txt");
			scanner = new Scanner(is);
			int T = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			while (T-- > 0) {
				String str = scanner.nextLine();
				count = 0;
				mem = new int[str.length()][str.length()];
				distinctPalindromes = new HashSet<String>();
				solver(str);
				System.out.println(count);
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void solver(String str) {
		for (int i = 0; i < str.length(); i++) {
			expand(str, i, i);
			if (i < str.length() - 1) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					expand(str, i, i + 1);
				}
			}
		}
	}

	private static void expand(String str, int x, int y) {
//		System.out.println("***********Expand***********" + str.substring(x, y + 1));
		while (x > -1 && y < str.length()) {
//			System.out.println("testing " + x + " :: " + y + " :: mem " + mem[x][y]);
			if (mem[x][y] == 0) {
				if ((str.charAt(x) == str.charAt(y))) {
					if (!distinctPalindromes.contains(str.substring(x, y + 1))) {
						count++;
						System.out.println("palinfrome found :: " + str.substring(x, y + 1));
						distinctPalindromes.add(str.substring(x, y + 1));
					}
				} else {
//					System.out.println("not a palinfrome :: " + str.substring(x, y + 1));
					break;
				}
				mem[x][y] = 1;
			}
			x--;
			y++;
		}
//		System.out.println("**********Terminate************");
	}
}
