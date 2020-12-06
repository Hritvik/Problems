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

public class DNA_HEALTH_CHECK_ROBIN_KARP_TLE {
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
				long temp = solver(genes, health, first, last, d);
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
//			System.out.print("gArray = ");
//			for (int i = 0; i < gArray.length; i++) {
//				System.out.print(gArray[i] + " ");
//			}
//			System.out.println();
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

	private static long solver(String[] genes, int[] health, int first, int last, String d) {
		long score = 0;
//		System.out.println("pattern = " + d);
		int patternLen = d.length();

		for (int i = first; i <= last; i++) {
			String str = genes[i];
			int strLen = str.length();
			long keyHash = hasher(str);
//			long keyHash2 = hasher2(str);
//			System.out.println("key = " + str);
//			System.out.println("***keyHash1 = " + keyHash);
//			System.out.println("***keyHash2 = " + keyHash2);
			long tempHash = hasher(d.substring(0, strLen));
//			long tempHash2 = hasher2(pattern.substring(0, strLen));
			for (int j = 0; (j < patternLen - strLen + 1); j++) {
//				System.out.println("trying :: " + pattern.substring(j, j + strLen));
//				System.out.println("hash1 = " + tempHash);
//				System.out.println("hash2 = " + tempHash2);
				if ((tempHash == keyHash) /* && ((tempHash2 == keyHash2) || (tempHash2 == -keyHash2)) */
						&& (str.equals(d.substring(j, j + strLen)))) {
					System.out.println(">>>matched = " + d.substring(j, j + strLen));
					score += health[i];
				}

				if (j + strLen < patternLen) {
//					System.out.println("+" + pattern.charAt(j + strLen));
//					System.out.println("-" + pattern.charAt(j));
					tempHash = tempHash + d.charAt(j + strLen) - d.charAt(j);
//					if (j % 2 == 0) {
//						tempHash2 = tempHash2 - pattern.charAt(j);
////						System.out.println("-" + pattern.charAt(j));
//					} else {
//						tempHash2 = tempHash2 + pattern.charAt(j);
////						System.out.println("+" + pattern.charAt(j));
//					}
//					if ((j + strLen) % 2 == 0) {
//						tempHash2 = tempHash2 + pattern.charAt(j + strLen);
////						System.out.println("+" + pattern.charAt(j + strLen));
//					} else {
//						tempHash2 = tempHash2 - pattern.charAt(j + strLen);
////						System.out.println("-" + pattern.charAt(j + strLen));
//					}
				}
			}
		}
		return score;
	}

	private static long hasher(String s) {
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i);
		}
		return sum;
	}

	private static long hasher2(String s) {
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				sum += s.charAt(i);
			} else {
				sum -= s.charAt(i);
			}
		}
		return sum;
	}

}
