//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Anagrams_Solved {

	public static void main(String[] args) {
		String[] B = {
				"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba",
				"abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa",
				"babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab",
				"bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb",
				"abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab",
				"aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba",
				"abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa",
				"aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb" };
		String[] C = { "cat", "dog", "god", "tca" };
		String[] A = { "cde", "bee" };
int a = 2^31-1;
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
		}
		ArrayList<ArrayList<Integer>> x = (new Anagrams_Solved()).anagrams(list);
		for (int i = 0; i < x.size(); i++) {
			for (int j = 0; j < x.get(i).size(); j++) {
				System.out.print(x.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		HashMap<Integer, ArrayList<Integer>> hashTable = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			int hash = hasher(A.get(i));
			int[] split = splitter(A.get(i));
			if (hashTable.containsKey(hash) && splitCompare(split, splitter(A.get(hashTable.get(hash).get(0))))) {
				System.out.println("if " + hash);
				hashTable.get(hash).add(i);
			} else {
				System.out.println("else " + hash);
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				hashTable.put(hash, temp);
			}
		}
		Set<Integer> keySet = hashTable.keySet();
		ArrayList<ArrayList<Integer>> listResult = new ArrayList<ArrayList<Integer>>();
		for (int key : keySet) {
			ArrayList<Integer> list = hashTable.get(key);
			for (int i = 0; i < list.size(); i++) {
				int temp = list.get(i) + 1;
				list.remove(i);
				list.add(i, temp);
			}
			listResult.add(list);
		}
		return listResult;
	}

	public boolean splitCompare(int[] split1, int[] split2) {
		for (int i = 0; i < split1.length; i++) {
			if (split1[i] != split2[i]) {
				return false;
			}
		}
		return true;
	}

	public int[] splitter(String A) {
		int[] split = new int[26];
		for (int i = 0; i < A.length(); i++) {
			split[A.charAt(i) - 97]++;
		}
		return split;
	}

	private int hasher(String string) {
		int hash1 = 0;
		int hash2 = 1;
		for (int i = 0; i < string.length(); i++) {
			hash1 += string.charAt(i);
		}
		for (int i = 0; i < string.length(); i++) {
			hash2 *= string.charAt(i);
		}
		System.out.println(string + " ::" + hash1 + " " + hash2);
		return (hash1 + hash2) % 1000000007;
	}

	public int[][] anagrams2(final String[] A) {
		ArrayList<int[]> hashList = new ArrayList<int[]>();
		HashMap<Integer, ArrayList<Integer>> groups = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < A.length; i++) {
			int[] tempHash = new int[27];
			for (int k = 0; k < A[i].length(); k++) {
				tempHash[A[i].charAt(k) - 97] += 1;
			}
			System.out.print("hash @ " + i + " :: ");
			for (int j = 0; j < tempHash.length; j++) {
				System.out.print(tempHash[j] + " ");
			}
			System.out.println();

			ArrayList<int[]> tempHashList = (ArrayList<int[]>) hashList.clone();
			for (int j = 0; j < A[i].length(); j++) {
				for (int k = 0; k < tempHashList.size(); k++) {
//					System.out.println("i = " + i + ", k = " + k + " char = " + (A[i].charAt(j)) + " z = "
//							+ (tempHashList.get(k)[A[i].charAt(j) - 97]));
					if (tempHashList.get(k)[A[i].charAt(j) - 97] == 0) {
						tempHashList.remove(k);
					} else {
						tempHashList.get(k)[A[i].charAt(j) - 97] -= 1;
					}
				}
			}
			if (tempHashList.size() == 0) {
				int[] hash = new int[27];
				for (int k = 0; k < A[i].length(); k++) {
					hash[A[i].charAt(k) - 97] += 1;
				}
				hash[26] = i;
				hashList.add(hash);
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i + 1);
				groups.put(i, temp);
			} else {
				groups.get(tempHashList.get(0)[26]).add(i + 1);
			}
		}
		Set<Integer> keySet = groups.keySet();
		int[] keyArray = new int[keySet.size()];
		int l = 0;
		int max = 0;
		int maxKeyIndex = 0;
		for (int key : keySet) {
			keyArray[l] = key;
			int temp = groups.get(key).size();
			if (temp > max) {
				max = temp;
				maxKeyIndex = l;
			}
			l++;
		}
		int temp = keyArray[0];
		keyArray[0] = keyArray[maxKeyIndex];
		keyArray[maxKeyIndex] = temp;
		int[][] result = new int[keySet.size()][];
		int j = 0;
		for (int k = 0; k < keyArray.length; k++) {
			ArrayList<Integer> list = groups.get(keyArray[k]);
			int[] tempArray = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				tempArray[i] = list.get(i);
			}
			result[j++] = tempArray;
		}
		return result;
	}
}
