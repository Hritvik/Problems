package UGLY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UglyNumbers4 {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			ArrayList<Integer> list = solver2(100);
			int T = Integer.parseInt(br.readLine());
			while (T != 0) {
				int N = Integer.parseInt(br.readLine());
				if (T > 1) {
					sb.append(list.get(N - 1) + "\n");
				} else {
					sb.append(list.get(N - 1));
				}
				T--;
			}
			System.out.println(sb);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static ArrayList<Integer> solver(int N) {
		int multiplier = 10;
		ArrayList<Integer> finalList = new ArrayList<Integer>();

		finalList.add(1);
		finalList.add(2);
		finalList.add(3);
		finalList.add(5);

		ArrayList<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		int index = 3;
		while (finalList.size() < N) {
			ArrayList<Integer> requiredNoList = new ArrayList<Integer>();
			for (int i = index; i <= index + multiplier * N; i++) {
				boolean isPrime = true;
				boolean isRequired = true;

				if (primeList.size() > 3) {
					for (int j = 0; j < 3; j++) {
						if (i % primeList.get(j) == 0) {
							isPrime = false;
							break;
						}
					}
					for (int j = 3; j < primeList.size(); j++) {
						if (i % primeList.get(j) == 0) {
							isPrime = false;
							isRequired = false;
							break;
						}
					}
				} else {
					for (int j = 0; j < primeList.size(); j++) {
						if (i % primeList.get(j) == 0) {
							isPrime = false;
							break;
						}
					}
				}
				if (isPrime) {
					primeList.add(i);
				} else if (isRequired) {
					requiredNoList.add(i);
				}

			}
			System.out.print(finalList.size() + " :: ");
//			System.out.print("requiredNoList :: ");
//			for (int j = 0; j < requiredNoList.size(); j++) {
//				System.out.print(requiredNoList.get(j) + " ");
//			}
//			System.out.println();
			finalList.addAll(requiredNoList);
			if (finalList.size() < N * 2) {
				Collections.sort(finalList);
			}
			requiredNoList.clear();
			index += multiplier * N;
		}

		System.out.print("finalList :: ");
		for (int j = 0; j < finalList.size(); j++) {
			System.out.print(finalList.get(j) + " ");
		}
		System.out.println();
		return finalList;
	}

	public static ArrayList<Integer> solver2(int N) {

		int multiplier = 1;
		ArrayList<Integer> finalList = new ArrayList<Integer>();

		finalList.add(1);
		finalList.add(2);
		finalList.add(3);
		finalList.add(5);

		ArrayList<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		int index = 3;
		while (finalList.size() < N) {
			ArrayList<Integer> requiredNoList = new ArrayList<Integer>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = index; i <= index + multiplier * N; i++) {
				list.add(i);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
				boolean isPrime = true;
				if (primeList.size() > 3) {
					for (int j = 0; j < 3; j++) {
						if (list.get(i) % primeList.get(j) == 0) {
							isPrime = false;
							for (int k = i; k < list.size(); k += primeList.get(j) - 1) {
								System.out.println("requiredNoList added :: "+list.get(k));
								requiredNoList.add(list.get(k));
//								list.remove(k);
							}
							break;
						}
					}
					for (int j = 3; j < primeList.size(); j++) {
						if (list.get(i) % primeList.get(j) == 0) {
							isPrime = false;
//							for (int k = i; k < list.size(); k += primeList.get(j) - 1) {
//								list.remove(k);
//							}
							break;
						}
					}
				} else {
					for (int j = 0; j < primeList.size(); j++) {
						System.out.println(
								list.get(i) + ", " + primeList.get(j) + " :: " + list.get(i) % primeList.get(j));
						if (list.get(i) % primeList.get(j) == 0) {
							isPrime = false;
							for (int k = i; k < list.size(); k += primeList.get(j) - 1) {
								System.out.println("requiredNoList added :: "+list.get(k));
								requiredNoList.add(list.get(k));
//								list.remove(k);
							}
							break;
						}
					}
				}
				if (isPrime) {
					primeList.add(list.get(i));
				}
				System.out.print("primeList :: ");
				for (int j = 0; j < primeList.size(); j++) {
					System.out.print(primeList.get(j) + " ");
				}
				System.out.println();
				System.out.print("requiredNoList :: ");
				for (int j = 0; j < requiredNoList.size(); j++) {
					System.out.print(requiredNoList.get(j) + " ");
				}
				System.out.println();

			}
			System.out.print(finalList.size() + " :: ");
//			System.out.print("requiredNoList :: ");
//			for (int j = 0; j < requiredNoList.size(); j++) {
//				System.out.print(requiredNoList.get(j) + " ");
//			}
//			System.out.println();
			finalList.addAll(requiredNoList);
			if (finalList.size() < N * 2) {
				Collections.sort(finalList);
			}
			requiredNoList.clear();
			index += multiplier * N;
		}

		System.out.print("finalList :: ");
		for (int j = 0; j < finalList.size(); j++) {
			System.out.print(finalList.get(j) + " ");
		}
		System.out.println();
		return finalList;

	}
}
