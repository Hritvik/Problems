package gridLand;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GridLand {
//TEST CASE 0 :: 1  8 	2
	static int gridlandProvinces(String s1, String s2) {
		System.out.println(s1);
		System.out.println(s2);
		String[][] gridland = new String[s1.length()][s2.length()];
		return 0;
	}

	public static void main(String[] args) throws IOException {
		InputStream is = null;
//		long startTime = System.currentTimeMillis();
		is = new FileInputStream("GRIDLAND/0.txt");
//		is = System.in;
		Scanner scanner = new Scanner(is);

		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int pItr = 0; pItr < p; pItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

			String s1 = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

			String s2 = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

			int result = gridlandProvinces(s1, s2);

		}

		scanner.close();
	}
}

class Node {
	char v;
	Node[] next = new Node[25];
}
