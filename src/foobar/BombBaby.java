package foobar;

import java.math.BigInteger;

public class BombBaby {
	public static void main(String[] args) {
		System.out.println(solution("876543256789987654", "876543256789987655"));
	}

	public static String solution(String x, String y) {
		BigInteger m = new BigInteger(x);
		BigInteger f = new BigInteger(y);
		BigInteger steps = BigInteger.ZERO;
		while (!m.equals(f)) {
//			System.out.println(m + " :: " + f + " :: " + steps);
			if (m.equals(BigInteger.ZERO) || f.equals(BigInteger.ZERO)) {
				break;
			}
			if (m.compareTo(f) > 0) {
				if (f.equals(BigInteger.ONE)) {
					steps = steps.add(m.subtract(f));
					m = BigInteger.ONE;
				} else {
					steps = steps.add(m.divide(f));
					m = m.mod(f);
				}

			} else if (m.compareTo(f) < 0) {
				if (m.equals(BigInteger.ONE)) {
					steps = steps.add(f.subtract(m));
					f = BigInteger.ONE;
				} else {
					steps = steps.add(f.divide(m));
					f = f.mod(m);
				}
			}
		}
		if ((m.equals(BigInteger.ONE) && f.equals(BigInteger.ONE))) {
			return steps.toString();
		} else {
			return "impossible";
		}

	}
}