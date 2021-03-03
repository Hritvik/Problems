package leetCode;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement {
	public static void main(String[] args) {
//		System.out.println((new NextGreaterElement()).nextGreaterElement(12));// 21
//		System.out.println((new NextGreaterElement()).nextGreaterElement(101));// 110
//		System.out.println((new NextGreaterElement()).nextGreaterElement(2147483476));// 2147483647
	}

	public int nextGreaterElement(int n) {
		String num = "" + n;
		List<Integer> digits = findDigitsOfNumber(num);
		return recursive(digits, n, num, 0, 0, "", false);
	}

	public int recursive(List<Integer> digits, int n, String num, int index, long output, String indent,
			boolean digitUpped) {
		System.out.println(indent + digits + " :: " + index + " :: " + output + " :: " + digitUpped);
		int currentDigit = num.charAt(index) - '0';
		int possibleDigit = (digitUpped) ? findNextGreaterDigit(digits, -1) : currentDigit;
		if (index == (num.length() - 1)) {
			int tempOutput = (int) (output + possibleDigit * (long) Math.pow(10, (num.length() - index - 1)));
			System.out.println(indent + possibleDigit + " :: " + tempOutput);
			if (tempOutput > n && tempOutput <= Integer.MAX_VALUE) {
				return tempOutput;
			} else {
				return -1;
			}
		} else {
			while (possibleDigit != Integer.MAX_VALUE) {
				long tempOutput = output + possibleDigit * (long) Math.pow(10, (num.length() - index - 1));
				System.out.println(indent + possibleDigit + " :: " + tempOutput);
				if (tempOutput <= Integer.MAX_VALUE) {
					List<Integer> tempDigits = new ArrayList<>();
					boolean deleted = false;
					for (int digit : digits) {
						if (!deleted && digit == possibleDigit) {
							deleted = true;
						} else {
							tempDigits.add(digit);
						}
					}
					int result = recursive(tempDigits, n, num, index + 1, tempOutput, indent + "  ",
							((digitUpped) ? digitUpped : (possibleDigit > currentDigit)));
					if (result != -1) {
						return result;
					}
				}
				possibleDigit = findNextGreaterDigit(digits, possibleDigit);
			}
			return -1;
		}
	}

	public List<Integer> findDigitsOfNumber(String num) {
		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			int digit = c - '0';
			digits.add(digit);
		}
		return digits;
	}

	public int findNextGreaterDigit(List<Integer> digits, int dig) {
		int answer = Integer.MAX_VALUE;
		for (int digit : digits) {
			if (dig < digit && digit < answer) {
				answer = digit;
			}
		}
		return answer;
	}
}
