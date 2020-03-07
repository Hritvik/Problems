import java.util.TreeMap;

public class SortedPermutationRankwithRepeats_next_attempt {
	public static void main(String[] args) {
		String a = "asasdsdsadasdadsad";//260772
//		String a = "aabbddcc";
//		String a = "aca";
//		String a = "abcd";
//		String a = "dcba";
//		String a = "asasdsdsadasdadsadasdsa";// 502900
//		String a = "sadasdsasassasas";// 208526

		System.out.println(a);
		System.out.println(new SortedPermutationRankwithRepeats_next_attempt().findRank(a));
	}

	private int findRank(String a) {
		int[] factorialArr = new int[a.length()];
		int count = 0;
		TreeMap<Character, Integer> freqMap = new TreeMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			if (freqMap.containsKey(a.charAt(i))) {
				freqMap.put(a.charAt(i), 1 + freqMap.get(a.charAt(i)));
			} else {
				freqMap.put(a.charAt(i), 1);
			}
		}

		for (int i = 0; i < a.length(); i++) {
			count += findCount(a, i, freqMap, factorialArr);
		}
		return (count + 1) % 1000003;

	}

	private int findCount(String a, int index, TreeMap<Character, Integer> freqMap, int[] factorialArr) {
		char c = a.charAt(index);
		int count = 0;
		for (char ch : freqMap.keySet()) {
			if (freqMap.get(ch) > 0) {
				if (ch != c) {
					freqMap.put(ch, freqMap.get(ch) - 1);
					count += findPermutes(a.length() - index - 1, freqMap, factorialArr);
					freqMap.put(ch, freqMap.get(ch) + 1);
				} else {
					freqMap.put(a.charAt(index), freqMap.get(a.charAt(index)) - 1);
					break;
				}
			}
		}
		return count;
	}

	public int findPermutes(int size, TreeMap<Character, Integer> freqMap, int[] factorialArr) {
		int count = 0;
		count = factorial(size, factorialArr);
		for (char c : freqMap.keySet()) {
			count /= factorial(freqMap.get(c), factorialArr);
		}
		return count;
	}

	private int factorial(int N, int[] factorialArr) {
		if (N == 1 || N == 0) {
			return 1;
		} else {
			if (factorialArr[N] != 0) {
				return factorialArr[N];
			} else {
				return N * factorial(N - 1, factorialArr);
			}
		}
	}

}
