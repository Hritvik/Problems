package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstNonRepeatingCharacterInaStream {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;
		Scanner in = new Scanner(System.in);
		String stringArray[] = null;
		String temp_line = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				N = Integer.parseInt(temp_line);
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
//				System.out.print("stringArray :: ");
//				for (int i = 0; i < stringArray.length; i++) {
//					System.out.print(stringArray[i] + " ");
//				}
//				System.out.println();

				streamParser(stringArray, sb);
				if (T != 1) {
					sb.append("\n");
				}
				T--;
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	private static void streamParser(String[] strArray, StringBuffer sb) {
		LinkedList<String> x = new LinkedList<String>();
		int[] hash = new int[26];
		for (int i = 0; i < strArray.length; i++) {
			int temp = strArray[i].toCharArray()[0];
			if (hash[temp - 97] == 0) {
				hash[temp - 97] = 1;
			} else {
				hash[temp - 97] = hash[temp - 97] + 1;
			}
//			System.out.println("char ::" + strArray[i] + " " + hash[temp - 97]);
			if (x.isEmpty()) {
				if (hash[temp - 97] > 1) {
					sb.append("-1 ");
				} else {					
					x.addFirst(strArray[i]);
					sb.append(strArray[i] + " ");
				}

			} else {
				if (x.peekLast().equals(strArray[i])) {
					x.pollLast();
					if (x.isEmpty()) {
//						System.out.println("-1 ");
						sb.append("-1 ");
					} else {
//						System.out.println("2 " + x.peekLast() + " ");
						while (!x.isEmpty() && hash[x.peekLast().toCharArray()[0] - 97] > 1) {
							x.pollLast();
						}
						if (!x.isEmpty()) {
//							System.out.println("x " + x.peekLast() + " ");
							sb.append(x.peekLast() + " ");
						} else {
							sb.append("-1 ");
						}

					}
				} else {
					x.addFirst(strArray[i]);
//					System.out.println("3 " + x.peekLast() + " ");
					while (!x.isEmpty() && hash[x.peekLast().toCharArray()[0] - 97] > 1) {
						x.pollLast();
					}
					if (!x.isEmpty()) {
//						System.out.println("y " + x.peekLast() + " ");
						sb.append(x.peekLast() + " ");
					} else {
						sb.append("-1 ");
					}

				}
			}
		}
	}

}
