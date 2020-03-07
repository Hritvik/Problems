import java.util.Set;
import java.util.TreeMap;

public class SortedPermutationRankwithRepeats_attempt1 {
	public static void main(String[] args) {
//		String a = "aacbcbdd";
//		String a = "aabbddcc";
//		String a = "aca";
//		String a = "abcd";
		String a = "asasdsdsadasdadsadasdsa";
		System.out.println(a);
		System.out.println(new SortedPermutationRankwithRepeats_attempt1().findRank(a));
	}

	public int findRank(String a) {
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			if (map.containsKey(a.charAt(i))) {
				map.put(a.charAt(i), 1 + map.get(a.charAt(i)));
			} else {
				map.put(a.charAt(i), 1);
			}
		}

		char[] list = new char[map.size()];
		Set<Character> keys = map.keySet();
		int i = 0;
		for (char key : keys) {
			list[i++] = key;
		}
		char[] prevList = list;
		char[] nextList = list;
//		System.out.println("coarse start " + fullListToStr(nextList));
		int count = 1;
		while (a.compareTo(listToStr(nextList, map)) > 0) {
			prevList = nextList.clone();
			int temp = nextBigPermutation(nextList, map);
			if (a.compareTo(listToStr(nextList, map)) > 0) {
				count += temp;
				System.out.println("currentStr = " + listToStr(nextList, map) + " :: count = " + count);
			}
		}
		char[] charArray = listToStr(prevList, map).toCharArray();
		prevList = charArray;
		nextList = charArray;
		System.out.println("grain start ::" + fullListToStr(nextList) + " :: target = " + a + " :: comp = "
				+ a.compareTo(fullListToStr(nextList)) + " :: count = " + count);
		System.exit(0);
		while (a.compareTo(fullListToStr(nextList)) > 0) {
			count++;
			prevList = nextList.clone();
			nextBigPermutation(nextList);
//			System.out.println("targetStr = " + a + " :: currentStr = " + fullListToStr(nextList) + " :: compare = "
//					+ a.compareTo(fullListToStr(nextList)) + " :: prevStr = " + fullListToStr(prevList));
			System.out.println("currentStr = " + fullListToStr(nextList) + " :: count = " + count);
		}
//		System.out.print("answer :: " + fullListToStr(nextList) + " :: count = " + count);
		return count;
	}

	public int findRank2(String a) {
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			if (map.containsKey(a.charAt(i))) {
				map.put(a.charAt(i), 1 + map.get(a.charAt(i)));
			} else {
				map.put(a.charAt(i), 1);
			}
		}

		char[] list = new char[map.size()];
		Set<Character> keys = map.keySet();
		int i = 0;
		for (char key : keys) {
			list[i++] = key;
		}
		char[] prevList = list;
		char[] nextList = list;

		char[] charArray = listToStr(list, map).toCharArray();
		prevList = charArray;
		nextList = charArray;
		System.out.println("grain start ::" + fullListToStr(nextList) + " :: target = " + a + " :: comp = "
				+ a.compareTo(fullListToStr(nextList)));
		int count = 0;
		while (a.compareTo(fullListToStr(nextList)) > 0) {
			count++;
			prevList = nextList.clone();
			nextBigPermutation(nextList);
//			System.out.println("targetStr = " + a + " :: currentStr = " + fullListToStr(nextList) + " :: compare = "
//					+ a.compareTo(fullListToStr(nextList)) + " :: prevStr = " + fullListToStr(prevList));
			System.out.println("currentStr = " + fullListToStr(nextList) + " :: count = " + count);

		}
		System.out.print("answer :: " + fullListToStr(nextList) + " :: count = " + count);
		return count;
	}

	public int nextBigPermutation(char[] list, TreeMap<Character, Integer> map) {
		int count = 0;
		int a = 0;
		int b = 0;
		for (int i = list.length - 1; i > 0; i--) {
			if (list[i - 1] < list[i]) {
				char temp = list[i - 1];
				int x = list.length - 1;
				for (int j = list.length - 1; j >= i; j--) {
					if (list[j] > list[i - 1]) {
						x = j;
						break;
					}
				}
				list[i - 1] = list[x];
				list[x] = temp;
				a = x;
				b = i - 1;
				partialSort(list, i);
				break;
			}
		}
		count = map.get(list[a]) * map.get(list[b]);
//		System.out.println("next :: " + fullListToStr(list) + " :: count = " + count);
		return count;
	}

	public int nextBigPermutation(char[] list) {
		int count = 0;
		for (int i = list.length - 1; i > 0; i--) {
			if (list[i - 1] < list[i]) {
				char temp = list[i - 1];
				int x = list.length - 1;
				for (int j = list.length - 1; j >= i; j--) {
					if (list[j] > list[i - 1]) {
						x = j;
						break;
					}
				}
				list[i - 1] = list[x];
				list[x] = temp;
				partialSort(list, i);
				break;
			}
		}
//		System.out.println("next :: " + fullListToStr(list));
		return count;
	}

	private void partialSort(char[] list, int i) {
		try {

			for (int j = i; j < list.length; j++) {
				int k = list.length - j + i - 1;
				if (k > j) {
					char temp = list[j];
					list[j] = list[k];
					list[k] = temp;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String listToStr(char[] list, TreeMap<Character, Integer> map) {
		String str = "";
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < map.get(list[i]); j++) {
				str += list[i];
			}
		}
		return str;
	}

	public String fullListToStr(char[] list) {
		String str = "";
		for (int i = 0; i < list.length; i++) {
			str += list[i];
		}
		return str;
	}

	public char[] compressStr(String a, TreeMap<Character, Integer> map) {
		char[] list = new char[map.size()];
		char prev = ' ';
		int j = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != prev) {
				list[j++] = a.charAt(i);
				prev = a.charAt(i);
			}
		}
		return list;
	}
}
