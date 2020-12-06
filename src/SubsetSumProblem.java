import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SubsetSumProblem {
	private static ArrayList<Integer> numbers = null;
	private static int target = 0;
	private static boolean found;
	private static HashMap<String, Boolean> memory = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while (T-- > 0) {
			memory = new HashMap<String, Boolean>();
			found = false;
			Integer.parseInt(sc.nextLine());
			numbers = new ArrayList<Integer>();
			String[] temp = sc.nextLine().split(" ");
			int total = 0;
			for (int i = 0; i < temp.length; i++) {
				numbers.add(Integer.parseInt(temp[i]));
				total += Integer.parseInt(temp[i]);
			}
			if (total % 2 == 0) {
				target = total / 2;
//				solver(0, 0, 0, "", "");
//				HashMap<Integer, Object> sum = new HashMap<Integer, Object>();
//				System.out.println("target = " + target);
				found = solver(0, target);
				if (!found) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			} else {
				System.out.println("NO");
			}

		}
		sc.close();
	}

	private static boolean solver(int i, int sum) {
		String key = i + "#" + sum;
		if (memory.containsKey(key)) {
			return memory.get(key);
		} else if (i == numbers.size() - 1) {
			if (numbers.get(i) == sum) {
				memory.put(key, true);
				return true;
			}
		} else if (i < numbers.size() - 1) {
			boolean result = solver(i + 1, sum) || solver(i + 1, sum - numbers.get(i));
			memory.put(key, result);
			return result;
		}
		memory.put(key, false);
		return false;
	}
//	private static ArrayList<Integer> solver(int i) {//TLE
//		if (!found && i < numbers.size()) {
////			System.out.println(numbers.get(i));
//			ArrayList<Integer> list = solver(i + 1);
//			if (!found) {
//				ArrayList<Integer> listCopy = (ArrayList<Integer>) list.clone();
////				System.out.println("input :: " + listCopy);
//				for (int j = 0; j < listCopy.size(); j++) {
//					if (numbers.get(i) + listCopy.get(j) == target) {
////						System.out.println("YES :: numbers.get(i) = " + numbers.get(i) + " :: listCopy.get(j) = "
////								+ listCopy.get(j));
//						System.out.println("YES");
//						found = true;
//						break;
//					} else if (numbers.get(i) + listCopy.get(j) < target) {
//						list.add(numbers.get(i) + listCopy.get(j));
//					}
//				}
//
//				if (numbers.get(i) == target) {
////					System.out.println("YES :: numbers.get(i) = " + numbers.get(i));
//					System.out.println("YES");
//					found = true;
//					return new ArrayList<Integer>();
//				} else if (numbers.get(i) < target) {
//					list.add(numbers.get(i));
//				}
////				System.out.println("output :: " + list);
//				return list;
//			}
//		}
//		return new ArrayList<Integer>();
//
//	}

//	private static void solver(int i, HashMap<Integer, Object> sum) {
//		if (i == numbers.size() - 1) {
//			for (int element : sum.keySet()) {
//				if (sum.containsKey(numbers.get(i) + element)) {
//					System.out.println("YES " +( numbers.get(i) + element));
//					found = true;
//					break;
//				}
//			}
//		} else {
//			sum.put(numbers.get(i), false);
//			for (int element : sum.keySet()) {
//				sum.put(numbers.get(i) + element, false);
//			}
//			solver(i + 1, sum);
//		}
//	}

//	private static void solver(int i, int count1, int count2, String set1, String set2) {
//		if (!flag) {
//			if (i > numbers.size()) {
//
//			} else if (i == numbers.size()) {
//				if (count1 == count2) {
////					System.out.println(set1 + " :: " + set2);
//					System.out.println("YES");
//					flag = true;
//				}
//			} else {
//				solver(i + 1, count1, count2 + numbers.get(i), set1, set2 + numbers.get(i) + ", ");
//				solver(i + 1, count1 + numbers.get(i), count2, set1 + numbers.get(i) + ", ", set2);
//			}
//		}
//	}
}
