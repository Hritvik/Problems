package DNA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

//TEST CASE 0 :: 0 19
//TEST CASE 1 :: 3218660 11137051
//TEST CASE 2 :: 15806635 20688978289
//TEST CASE 33:: 11674463 11674463
public class DNA_HEALTH_KMP_TLE {
	private static Scanner scanner = null;

	public static void main1(String[] args) {
		try {
			InputStream is = null;
			long startTime = System.currentTimeMillis();
			is = new FileInputStream("c.txt");
//			is = System.in;
			scanner = new Scanner(is);
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String[] genes = new String[n];

			String[] genesItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				String genesItem = genesItems[i];
				genes[i] = genesItem;
			}

			int[] health = new int[n];

			String[] healthItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int healthItem = Integer.parseInt(healthItems[i]);
				health[i] = healthItem;
			}

			int s = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			long max = 0;
			long min = 999999999;
			for (int sItr = 0; sItr < s; sItr++) {
				String[] firstLastd = scanner.nextLine().split(" ");

				int first = Integer.parseInt(firstLastd[0]);

				int last = Integer.parseInt(firstLastd[1]);

				String d = firstLastd[2];
				long temp = 0;// solver(genes, health, first, last, d);
				if (temp > max) {
					max = temp;
				}
				if (temp < min) {
					min = temp;
				}
			}
			System.out.println(min + " " + max);
			long endTime = System.currentTimeMillis();
			long duration = (endTime - startTime);
			System.out.println("duration = " + duration);
			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		InputStream is = null;
		BufferedReader br = null;
		int T = 0;
		int N = 0;
		long startTime = System.currentTimeMillis();
		String stringArray[] = null;
		String temp_line = null;
		// ArrayList<Long> intArray = new ArrayList<Long>();
		String genes[] = null;
		int health[] = null;

		try {
			is = new FileInputStream("DNA/33.txt");
//			is = System.in;
			br = new BufferedReader(new InputStreamReader(is));
			temp_line = br.readLine();
			N = Integer.parseInt(temp_line);
			temp_line = br.readLine();
			genes = temp_line.split(" ");
			temp_line = br.readLine();
			stringArray = temp_line.split(" ");
			health = new int[stringArray.length];
			for (int i = 0; i < stringArray.length; i++) {
				health[i] = Integer.parseInt(stringArray[i]);
			}
			T = Integer.parseInt(br.readLine());
			long max = 0;
			long min = 999999999;
			while (T != 0) {
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				int first = Integer.parseInt(stringArray[0]);
				int last = Integer.parseInt(stringArray[1]);
				String d = stringArray[2];

				long temp = solver(genes, health, first, last, d);
//				System.out.println("value = " + temp);
				if (temp > max) {
					max = temp;
				}
				if (temp < min) {
					min = temp;
				}
				T--;
			}

			System.out.println(min + " " + max);
			long endTime = System.currentTimeMillis();
			long duration = (endTime - startTime);
			System.out.println("duration = " + duration);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main3(String[] args) {
		String a = "AAACAAAAAC";
		String b = "AABAACAABAA";
		String c = "AAABAAA";
		String d = "BABA";
		int[] x = lps(c);
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

	public static void main4(String[] args) {
		String pattern = "BABA";
		String d = "BABAAABABABA";
		String pattern1 = "AAAA";
		String d1 = "AAAAABAAABA";
		strMatch(pattern, d);
	}

	private static long solver(String[] genes, int[] health, int first, int last, String d) {
		long score = 0;
		for (int i = first; i <= last; i++) {
			String str = genes[i];
			score += health[i] * strMatch(str, d);
		}
		return score;
	}

	private static long strMatch(String pattern, String d) {
//		System.out.println("pattern = " + pattern);
//		System.out.println("d = " + d);
		long count = 0;
		int[] lps = lps(pattern);
		int i = 0;
		int j = 0;
		while (i < d.length()) {
//			System.out.println(i + " :: " + j);
//			System.out.println(d.charAt(i) + " :: " + pattern.charAt(j));
			if (d.charAt(i) == pattern.charAt(j)) {
//				System.out.println("char match = " + d.charAt(i));
				i++;
				j++;
				if (j == lps.length) {
//					System.out.println("matched :: " + d.substring(j - pattern.length(), j));
					count++;
					j = lps[j - 1];
				}
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return count;
	}

	private static int[] lps(String pattern) {
		int strLen = pattern.length();
		int[] lps = new int[strLen];
		try {
			for (int i = 0; i < pattern.length(); i++) {
				for (int j = 0; j < i; j++) {
					if (pattern.substring(0, j + 1).equals(pattern.substring(i - j, i + 1))) {
						lps[i] = j + 1;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.print("lps = ");
		for (int i = 0; i < lps.length; i++) {
//			System.out.print(lps[i] + " ");
		}
//		System.out.println();
		return lps;
	}
}
