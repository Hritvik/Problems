package Samsung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ThreeTravellers {
	public static void main(String[] args) {
		int size = 8;
		int[][] matrix = new int[size][size];
		HashMap<String, Integer> positionTimeMap = new HashMap<String, Integer>();
		positionTimeMap.put("0_0", 0);
		positionTimeMap.put("2_3", 0);
		positionTimeMap.put("7_4", 0);
		ThreeTravellers.positionAfterTHours(size, 64, matrix, positionTimeMap);
	}

	public static void positionAfterTHours(int N, int t, int[][] matrix, HashMap<String, Integer> positionTimeMap) {
		int fullPath = (int) Math.pow(N, 2);
		System.out.println("fullPath = " + fullPath);
		ArrayList<int[]> positionArray = new ArrayList<int[]>();
		recursive(N, fullPath - 1, 0, 0, null, "UR", positionArray, positionTimeMap);
		for (int i = 0; i < positionArray.size(); i++) {
			matrix[positionArray.get(i)[0]][positionArray.get(i)[1]]++;
			for (int k = 0; k < matrix.length; k++) {
				for (int j = 0; j < matrix.length; j++) {
					System.out.print(matrix[k][j] + " ");
				}
				System.out.println();
			}
			System.out.println("-------------------------");
		}
		System.out.println("map = " + positionTimeMap);
		Set<String> keySet = positionTimeMap.keySet();
		for (String key : keySet) {
			System.out.println("key = " + key);
			int T = fullPath - positionTimeMap.get(key) - 1;
			int index = T + t;
			if (index >= positionArray.size()) {
				index = index % positionArray.size();
			}
			System.out.println("new position = " + positionArray.get(index)[0] + ", " + positionArray.get(index)[1]);
		}
	}

	public static int[] recursive(int N, int T, int x, int y, String ppMove, String pMove,
			ArrayList<int[]> positionArray, HashMap<String, Integer> positionTimeMap) {
		int[] couple = { x, y };
		positionArray.add(couple);
		if (positionTimeMap.containsKey(x + "_" + y)) {
			positionTimeMap.put(x + "_" + y, T);
		}
		System.out.println("ppMove = " + ppMove + " :: pMove = " + pMove);
		if (T > 0) {
			int x_ = x;
			int y_ = y;
			String nMove = null;
			if (pMove.equals("UR")) {
				if (x - 1 > -1 && y + 1 < N) {
					nMove = "UR";
				} else if (y + 1 < N) {
					nMove = "R";
				} else if (x + 1 < N) {
					nMove = "D";
				} else {
					System.out.println("xxxx");
				}
			}
			if (pMove.equals("DL")) {
				if (x + 1 < N && y - 1 > -1) {
					nMove = "DL";
				} else if (x + 1 < N) {
					nMove = "D";
				} else if (y + 1 < N) {
					nMove = "R";
				}
			}
			if (pMove.equals("R")) {
				if (ppMove.equals("UR")) {
					nMove = "DL";
				} else if (ppMove.equals("DL")) {
					nMove = "UR";
				}
			}
			if (pMove.equals("D")) {
				if (ppMove.equals("UR")) {
					nMove = "DL";
				} else if (ppMove.equals("DL")) {
					nMove = "UR";
				}
			}
			if (nMove == null) {
				System.out.println("nMove nout found :: pMove = " + pMove);
			}
			if (nMove.equals("UR")) {
				x_ = x - 1;
				y_ = y + 1;
			} else if (nMove.equals("DL")) {
				x_ = x + 1;
				y_ = y - 1;
			} else if (nMove.equals("D")) {
				x_ = x + 1;
			} else if (nMove.equals("R")) {
				y_ = y + 1;
			} else {
				System.out.println("end reached i suppose :: " + T);
			}
			System.out.println("nMove = " + nMove);
			int[] temp = recursive(N, T - 1, x_, y_, pMove, nMove, positionArray, positionTimeMap);
			return temp;

		} else {
			int[] temp = { x, y };
			return temp;
		}
	}

}
