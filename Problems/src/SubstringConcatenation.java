import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {
	public static void main(String[] args) {
//		String A = "barfoothefoobarman";
//		ArrayList<String> B = new ArrayList<String>();
//		B.add("foo");
//		B.add("bar");

		String A = "abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa";
		ArrayList<String> B = new ArrayList<String>();
		B.add("cac");
		B.add("aaa");
		B.add("aba");
		B.add("aab");
		B.add("abc");

		ArrayList<Integer> x = (new SubstringConcatenation()).findSubstring(A, B);
		System.err.print("answer :: ");
		for (int i = 0; i < x.size(); i++) {
			System.out.print(x.get(i) + ",");
		}
		System.out.println();
	}

	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		long bigHash = 0;
		HashMap<Long, String> hashMap = new HashMap<Long, String>();
		ArrayList<Long> hashList = new ArrayList<Long>();
		for (int i = 0; i < B.size(); i++) {
			long hash = hash(B.get(i));
			hashList.add(hash);
			hashMap.put(hash, B.get(i));
			bigHash += hash;
		}

//		System.out.println("bigHash = " + bigHash);
		int strLength = B.get(0).length();
		int fullLength = strLength * B.size();

//		System.out.println("length = " + length);
		if (fullLength <= A.length()) {
			long currentHash = hash(A.substring(0, fullLength));
//			System.out.println(A.substring(0, length) + " :: " + currentHash);
			if (currentHash == bigHash) {
				result.add(0);
			}
			for (int i = fullLength; i < A.length(); i++) {
				System.out.println(i + " adding char = " + A.charAt(i));
				System.out.println((i - fullLength) + " removing char = " + A.charAt(i - fullLength));
				currentHash = currentHash + A.charAt(i) - A.charAt(i - fullLength);
				boolean flag = true;
				System.out.println("***********************************");
				for (int j = 0; j < hashList.size(); j++) {
					long temp = hashList.get(j);
					int beginIndex = i - fullLength + j;
					System.out.println("beginIndex = " + beginIndex);
					System.out.println("endIndex = " + (beginIndex + strLength));
					System.out.println("subStr = " + A.substring(beginIndex + 1, beginIndex + strLength + 1));
					temp = temp - A.charAt(beginIndex) + (strLength) * A.charAt(beginIndex + strLength);
					hashList.remove(j);
					hashList.add(j, temp);
					if (!hashMap.containsKey(temp)) {
						System.out.println(
								temp + " not in the set :: " + A.substring(beginIndex + 1, beginIndex + strLength + 1));
						System.out.println(hashMap);
						flag = false;
					}
				}
				if (flag) {
					System.out.println("index added :: " + (i - fullLength + 1));
					result.add(i - fullLength + 1);
				}
				System.out.println("***********************************");
//				System.out.println(A.substring(i - length + 1, i + 1) + " :: " + currentHash);
//				if (currentHash == bigHash) {
//					System.out.println("***********************************");
//					boolean flag = true;
//					for (int j = 0; j < B.size(); j++) {
//						int beginIndex = i - fullLength + 1 + j * strLength;
//						System.out.println("beginIndex = " + beginIndex);
//						System.out.println("subStr = " + A.substring(beginIndex, beginIndex + strLength));
//						String subStr = A.substring(beginIndex, beginIndex + strLength);
//						if (!hashMap.containsKey(hash(subStr))) {
//							flag = false;
//							break;
//						}
//					}
//					if (flag) {
//						System.out.println("index added :: " + (i - fullLength + 1));
//						result.add(i - fullLength + 1);
//					}
//					System.out.println("***********************************");
//				}
			}
		}
		return result;
	}

	public long hash(String S) {

		long hash = 0;
		for (int i = 0; i < S.length(); i++) {
			hash += (i + 1) * (S.charAt(i));
		}
//		System.out.println("hash :: " + S + " :: " + hash);
		return hash;
	}

}
