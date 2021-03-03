
public class ValidPalindrome2 {
	public static void main(String[] args) {
		System.out.println(new ValidPalindrome2().validPalindrome("abca"));
	}

	public boolean validPalindrome(String s) {
		return recursive(s, 0, s.length() - 1, false);
	}

	public boolean recursive(String s, int i, int j, boolean skipped) {
		if (i < j) {
			char x = s.charAt(i);
			char y = s.charAt(j);
			System.out.println(x + " " + y);
			if (x == y) {
				System.out.println("same");
				return recursive(s, i + 1, j - 1, skipped);
			} else {
				System.out.println("different");
				if (skipped) {
					return false;
				}
				return recursive(s, i + 1, j, true) || recursive(s, i, j - 1, true);
			}
		} else {
			return true;
		}
	}

}
