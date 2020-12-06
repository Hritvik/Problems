package array;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumIndex_Solved {
	public static void main(String[] args) {
		try {

			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				int N = Integer.parseInt(br.readLine());
				String[] temp = br.readLine().split(" ");
				int[] arr = new int[N];
				for (int i = 0; i < temp.length; i++) {
					arr[i] = Integer.parseInt(temp[i]);
				}
				if (N > 1) {
					System.out.println(solver(arr));
				} else {
					System.out.println("0");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int solver(int[] arr) {
		int increment = arr.length;
		boolean found = false;
		while (--increment > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (i + increment < arr.length) {
					if (arr[i] < arr[i + increment]) {
						System.out
								.println(arr[i] + "[" + i + "] :: " + arr[i + increment] + "[" + (i + increment) + "]");
						found = true;
						break;
					}
				} else {
					break;
				}
			}
			if (found) {
				break;
			}
		}
		return increment;
	}
}
