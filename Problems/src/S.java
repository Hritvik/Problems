import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class S {
	static HashMap<Integer, ArrayList<Integer>> relations = new HashMap<Integer, ArrayList<Integer>>();
	static int[][] aMatrix = null;
	static int[][] bMatrix = null;
	static int[][] dMatrix = null;
	static int N = 0;
	static int K = 0;
	static int C = 0;

	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);
			K = Integer.parseInt(temp[2]);
			C = Integer.parseInt(br.readLine());
			aMatrix = new int[N + 1][N + 1];
			bMatrix = new int[N + 1][N + 1];
			dMatrix = new int[N + 1][N + 1];
			relations = new HashMap<Integer, ArrayList<Integer>>();
			for (int x = 0; x < M; x++) {
				temp = br.readLine().split(" ");
				int i = Integer.parseInt(temp[0]);
				int j = Integer.parseInt(temp[1]);
				int a = Integer.parseInt(temp[2]);
				int b = Integer.parseInt(temp[3]);
				int d = Integer.parseInt(temp[4]);
				aMatrix[i][j] = a;
				bMatrix[i][j] = b;
				dMatrix[i][j] = d;
				ArrayList<Integer> list = null;
				if (relations.containsKey(i)) {
					list = relations.get(i);
				} else {
					list = new ArrayList<Integer>();
				}
				list.add(j);
				relations.put(i, list);
			}
			System.out.println(relations);
			ArrayList<double[]> result = recursive(0, 1, C, 0);
			for (int i = 0; i < result.size(); i++) {
				double[] pair = result.get(i);
				System.out.println(pair[0] + " " + pair[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<double[]> recursive(int previousState, int state, double price, int time) {
		System.out.println("state = " + state + " :: price = " + price + " :: time = " + time);
		ArrayList<double[]> result = new ArrayList<double[]>();
		if (time <= K) {
			if (state == N && time == K) {
				double[] temp = { price, time };
				result.add(temp);
			} else {
				ArrayList<Integer> list = relations.get(state);
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) != previousState) {
						int newState = list.get(i);
						double newPrice = aMatrix[state][list.get(i)] * price + bMatrix[state][list.get(i)];
						if (newPrice < 0) {
							newPrice = 0;
						}
						int newTime = time + dMatrix[state][list.get(i)];
						result.addAll(recursive(state, newState, newPrice, newTime));
					}
				}
			}

		}
		return result;
	}

}
