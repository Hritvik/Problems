import java.util.ArrayList;

public class StrongPasswordChecker {
	public static void main(String[] args) {
//		String s = "aaa111";//2
//		String s = "AAABABABABABABABABAB1";// 2
//		String s = "aaaaaaaaaaaaaaaaaaaaa";// 7
		String s = "1234567890123456Baaaaa";// 3
		System.out.println(new StrongPasswordChecker().strongPasswordChecker(s));
	}

	public int strongPasswordChecker(String s) {
		int shortlengthCount = 0;
		if (s.length() < 6) {
			shortlengthCount = 6 - s.length();
		}
		int longlengthCount = 0;
		if (s.length() > 20) {
			longlengthCount = s.length() - 20;
		}

		int lowerCaseCount = 1;
		int upperCaseCount = 1;
		int digitCount = 1;
		ArrayList<Integer> repeating = new ArrayList<Integer>();
		char prevChar = '#';
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
//			System.out.println(prevChar + " :: " + currChar);
			if (currChar == prevChar) {
				count++;
				if (i == s.length() - 1 && count > 0) {
//					System.out.println("b count " + count);
					repeating.add(count);
				}
			} else {
				if (count > 0) {
					repeating.add(count);
				}
				count = 1;
			}
			if (digitCount == 1 && currChar <= '9' && currChar >= '0') {
				digitCount = 0;
			}
			if (lowerCaseCount == 1 && currChar >= 'a' && currChar <= 'z') {
				lowerCaseCount = 0;
			}
			if (upperCaseCount == 1 && currChar >= 'A' && currChar <= 'Z') {
				upperCaseCount = 0;
			}
			prevChar = currChar;
		}
		int repeatCount = 0;
		for (int i = 0; i < repeating.size(); i++) {
//			System.out.println(repeating.get(i));
			repeatCount += repeating.get(i) / 3;
		}
		int sum = lowerCaseCount + upperCaseCount + digitCount;
		System.out.println("shortlengthCount = " + shortlengthCount);
		System.out.println("longlengthCount = " + longlengthCount);
		System.out.println("lowerCaseCount = " + lowerCaseCount);
		System.out.println("upperCaseCount = " + upperCaseCount);
		System.out.println("digitCount = " + digitCount);
		System.out.println("repeatCount = " + repeatCount);

		if (shortlengthCount == 0 && longlengthCount == 0) {
			return Math.max(sum, repeatCount);
		} else if (shortlengthCount != 0) {
			return Math.max(shortlengthCount, Math.max(sum, repeatCount));
		} else if (longlengthCount != 0) {
//			return sum + Math.max(longlengthCount, repeatCount);
//			return Math.max(longlengthCount, Math.max(sum, repeatCount));
			return Math.max(longlengthCount, repeatCount - sum) + sum;
		} else {
			return 0;
		}

	}
}
