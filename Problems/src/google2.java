import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class google2 {

	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			int level = Integer.parseInt(br.readLine());
			int L = level;
			int[] tree = new int[(int) Math.pow(2, level)];
			int i = 0;
			while (L-- > 0) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < temp.length; j++) {
					tree[i++] = Integer.parseInt(temp[j]);
				}
			}
			int a = 0;
			for (int j = 0; j < L; j++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int k = a; k < Math.pow(2, j); k++) {
					list.add(tree[k]);
				}
				solver(list);
				a += 2 * j;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void solver(ArrayList<Integer> list) {
		
	}

	private static int findGcd(int a, int b) {
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int gcd = 1;
		for (int i = 2; i < a; i++) {
			while (a % i == 0 && b % i == 0) {
				a /= i;
				b /= i;
				gcd *= i;
			}
		}
		return gcd;
	}
}
