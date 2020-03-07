package array;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StockSaleAndBuy_Solved {
	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		try {
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				int N = Integer.parseInt(br.readLine());
				String[] temp = br.readLine().split(" ");
				int[] arr = new int[N];
				for (int i = 0; i < N; i++) {
					arr[i] = Integer.parseInt(temp[i]);
				}
				solver(arr);
			}
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

	public static void solver(int[] A) {
		int i = 0;
		String S = "";
		while (i < A.length) {
			if (i + 1 < A.length && A[i + 1] < A[i]) {
				while (i + 1 < A.length && A[i + 1] < A[i]) {
					i++;
				}
			}
			if (i + 1 < A.length && A[i + 1] > A[i]) {
				if (i < A.length) {
					S += " (" + i + " ";
				}
				while (i + 1 < A.length && A[i + 1] > A[i]) {
					i++;
				}
				if (i < A.length) {
					S += +i + ") ";
				}
			}
			i++;
		}
		if (S.trim().isEmpty()) {
			System.out.println("No Profit");
		} else {
			System.out.println(S.trim().replace("  ", " "));
		}

	}

}
