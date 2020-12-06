package largestRectangle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class attempt2 {
	static int[][] matrix;
//	static HashMap<String, Long> memoryT = new HashMap<String, Long>();
	static long[][][][] memory = null;
	static int R = 0;
	static int C = 0;

	// 0 :: 4 2
	public static void main(String[] args) {
		InputStream is = null;

		int T = 0;
		try {
//			is = System.in;
			is = new FileInputStream("Largest_Rectangle/0.txt");
			InputStreamReader in = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(in);
			StringBuffer sb = new StringBuffer();
			String[] strArray = null;
			T = Integer.parseInt(bf.readLine());
			while (T != 0) {
				String temp[] = bf.readLine().split(" ");
				R = Integer.parseInt(temp[0]);
				C = Integer.parseInt(temp[1]);
				memory = new long[R][R][C][C];
				matrix = new int[R][C];
				strArray = bf.readLine().split(" ");
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						matrix[i][j] = Integer.parseInt(strArray[i * C + j]);
						System.out.print(matrix[i][j] + " ");
					}
					System.out.println();
				}
				long result = 0;
				sb.append(result);
				if (T != 1) {
					sb.append("\n");
				}
				T--;
			}
			System.out.println(sb);
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void solver() {
		

	}
}
