
public class ValidNumber {
	public static void main(String[] args) {
		String s = "+3.";
		System.out.println(s);
		System.out.println((new ValidNumber()).isNumberInternal(s, true, true));
	}

	public boolean isNumber(String s) {
		return isNumberInternal(s.trim(), true, true);
	}

	public boolean isNumberInternal(String s, boolean exponentialPossible, boolean decimalPossible) {
		boolean exponentialPresent = false;
		boolean decimalPresent = false;
		if (!s.isEmpty()) {
			int exponentialIndex = s.indexOf('e');
			int decimalIndex = s.indexOf('.');
			if (exponentialIndex != -1) {
				exponentialPresent = true;
			}
			if (decimalIndex != -1) {
				decimalPresent = true;
			}
//			System.out.println(s + " :: e " + exponentialPresent + " [" + exponentialPossible + "]");
//			System.out.println(s + " :: . " + decimalPresent + " [" + decimalPossible + "]");
			if (exponentialPresent && exponentialPossible) {
				if (exponentialIndex < s.length() - 1) {
					int start = exponentialIndex + 1;
					if (s.charAt(start) == '+' || s.charAt(start) == '-') {
						start++;
					}
					String r = s.substring(start, s.length());
					String l = s.substring(0, exponentialIndex);
					if (l.isEmpty() || r.isEmpty()) {
						return false;
					}
					boolean a = isPureNumber(r);
					boolean b = isNumberInternal(l, false, decimalPossible);
					return a && b;
				} else {
					return false;
				}
			} else if (decimalPresent && decimalPossible) {
				int start = 0;
				if (s.charAt(start) == '+' || s.charAt(start) == '-') {
					start++;
				}
				String l = s.substring(start, decimalIndex);
				String r = s.substring(decimalIndex + 1, s.length());
				if (l.isEmpty() && r.isEmpty()) {
					return false;
				}
				boolean a = isPureNumber(r);
				boolean b = isNumberInternal(l, exponentialPossible, false);
				return (a || r.isEmpty()) && (b || l.isEmpty());
			} else if (!decimalPresent && !exponentialPresent) {
				int start = 0;
				if (s.charAt(start) == '+' || s.charAt(start) == '-') {
					start++;
				}
				s = s.substring(start, s.length());
				return isPureNumber(s);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean isPureNumber(String s) {
		if (s.isEmpty()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0')) {
				return false;
			}
		}
		return true;
	}
}
