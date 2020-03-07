package array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LargestRectangleOf1sWithSwappingOfColumnsAllowed_Solved {
	static int largestArea = 0;

	public class Element {
		int h1;
		int h2;
		int area;

		Element(int h1, int h2, int area) {
			this.h1 = h1;
			this.h2 = h2;
			this.area = area;
		}

		@Override
		public String toString() {
			return area + "[" + h1 + "," + h2 + "]";
		}
	}

	public static void main(String[] args) {
//		int[] col = { 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0 };
//		findWindows(col);
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while (T-- > 0) {
			String[] temp = sc.nextLine().split(" ");
			int R = Integer.parseInt(temp[0]);
			int C = Integer.parseInt(temp[1]);
			temp = sc.nextLine().split(" ");
			int[][] matrix = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					matrix[i][j] = Integer.parseInt(temp[i * C + j]);
				}
			}
//			printMatrix(matrix);
			int result = (new LargestRectangleOf1sWithSwappingOfColumnsAllowed_Solved()).solve(matrix, R, C);
			System.out.println(result);
		}
		sc.close();
	}

	private int solve(int[][] matrix, int R, int C) {
		HashMap<String, ArrayList<Element>> memory = new HashMap<String, ArrayList<Element>>();
//		printMatrix(matrix);
		ArrayList<Element> result = recursive(matrix, 0, new int[] { 0, R - 1 }, memory, R, C, "");
		int max = 0;
		for (int i = 0; i < result.size(); i++) {
			int area = result.get(i).area;
			if (area > max) {
				max = area;
			}
		}
		return max;
	}

	private ArrayList<Element> recursive(int[][] matrix, int i, int[] incomingWindow,
			HashMap<String, ArrayList<Element>> memory, int R, int C, String tab) {
		ArrayList<Element> elements = new ArrayList<Element>();
//		System.out
//				.println(tab + "i = " + i + " :: incomingWindow [" + incomingWindow[0] + "," + incomingWindow[1] + "]");
		if (i > C - 1) {
			elements.add(new Element(incomingWindow[0], incomingWindow[1], 0));
		} else {
			if (memory.containsKey(i + "#" + incomingWindow[0] + "#" + incomingWindow[1])) {
//				System.out.println(tab + "grabbed from memory");
				elements.addAll(memory.get(i + "#" + incomingWindow[0] + "#" + incomingWindow[1]));
			} else {
				int[] col = new int[R];
				for (int j = 0; j < col.length; j++) {
					col[j] = matrix[j][i];
				}
				ArrayList<int[]> windowList = findWindows(col);
//				System.out.print(tab + "i = " + i + " :: windows :: ");
//				for (int j = 0; j < windowList.size(); j++) {
//					System.out.print("[" + windowList.get(j)[0] + ", " + windowList.get(j)[1] + "], ");
//				}
//				System.out.println();
				for (int j = 0; j < windowList.size(); j++) {
					int[] window = windowList.get(j);
					if (overlap(window, incomingWindow)) {
						int[] reducedWindow = findNewWindow(incomingWindow, window);
//						System.out.println(tab + "i = " + i + " :: reducedWindow :: [" + reducedWindow[0] + ","
//								+ reducedWindow[1] + "]");
						ArrayList<Element> elementsList = recursive(matrix, i + 1, reducedWindow, memory, R, C,
								tab + "    ");
						for (int k = 0; k < elementsList.size(); k++) {
							Element element = elementsList.get(k);
							int newArea = 1 + element.h2 - element.h1 + element.area;
//							System.out.println(tab + "i = " + i + " :: areaWith choice " + j + "-" + k + " :: 1 + ["
//									+ element.h2 + " - " + element.h1 + "] + " + element.area + " = " + newArea);
							Element newElement = new Element(element.h1, element.h2, newArea);
							elements.add(newElement);
						}

					} else {
//						System.out.println(tab + "i = " + i + " :: ithWindow :: [" + window[0] + "," + window[1]
//								+ "] didn't match");
					}
				}
//				System.out.println(
//						tab + "i = " + i + " :: *skip row* :: [" + incomingWindow[0] + "," + incomingWindow[1] + "]");
				ArrayList<Element> elementsList = recursive(matrix, i + 1, incomingWindow, memory, R, C, tab + "	");
				elements.addAll(elementsList);
			}
		}
		memory.put(i + "#" + incomingWindow[0] + "#" + incomingWindow[1], elements);
		return elements;
	}

	private static boolean overlap(int[] ithWindow, int[] prevWindow) {
		if ((prevWindow[0] < ithWindow[0] && prevWindow[0] < ithWindow[1] && prevWindow[1] < ithWindow[0]
				&& prevWindow[1] < ithWindow[1])
				|| (prevWindow[0] > ithWindow[0] && prevWindow[0] > ithWindow[1] && prevWindow[1] > ithWindow[0]
						&& prevWindow[1] > ithWindow[1])) {
			return false;
		}
		return true;
	}

	private static int[] findNewWindow(int[] prevWindow, int[] ithWindow) {
		int[] newWindow = { Math.max(prevWindow[0], ithWindow[0]), Math.min(prevWindow[1], ithWindow[1]) };
		return newWindow;
	}

	private static ArrayList<int[]> findWindows(int[] col) {
		ArrayList<int[]> windows = new ArrayList<int[]>();
		boolean lookingForOne = true;
		int startIndex = 0;
		int endIndex = 0;
		for (int j = 0; j < col.length; j++) {
			if (lookingForOne && col[j] == 1) {
				startIndex = j;
				lookingForOne = false;
			} else if (!lookingForOne && col[j] == 1) {

			} else if (lookingForOne && col[j] == 0) {

			} else if ((!lookingForOne && col[j] == 0)) {
				endIndex = j - 1;
				windows.add(new int[] { startIndex, endIndex });
				lookingForOne = true;
			}
			if (!lookingForOne && j == col.length - 1) {
				endIndex = j;
				windows.add(new int[] { startIndex, endIndex });
				lookingForOne = true;
			}
		}
		return windows;
	}

	private static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
