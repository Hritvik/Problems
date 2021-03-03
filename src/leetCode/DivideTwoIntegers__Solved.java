package leetCode;

public class DivideTwoIntegers__Solved {
	// https://leetcode.com/problems/divide-two-integers/
	public int divideSimple(int dividend, int divisor) {

		long divisorAbs = Math.abs((long) divisor);
		long dividendAbs = Math.abs((long) dividend);
		long sum = divisorAbs;
		long count = 0;
		while (sum <= dividendAbs) {
			sum += divisorAbs;
			count++;
			if (count > (long) Integer.MAX_VALUE + 1) {
				System.out.println("break");
				break;
			}
		}

		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			if (count > (long) Integer.MAX_VALUE + 1) {// overflow
				return Integer.MAX_VALUE;
			} else {
				return (int) -count;
			}
		} else {
			if (count > Integer.MAX_VALUE) {// overflow
				return Integer.MAX_VALUE;
			} else {
				return (int) count;
			}
		}
	}

	public int divideBitOperations(int dividend, int divisor) {

		long divisorAbs = Math.abs((long) divisor);
		long dividendAbs = Math.abs((long) dividend);
		if (divisorAbs > dividendAbs) {
			return 0;
		} else if (divisorAbs == dividendAbs) {
			if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
				return -1;
			} else {
				return 1;
			}
		}
		long sum = 0;
		long quotient = 0;
		while (dividendAbs - sum >= divisorAbs) {
			long[] quotient_and_sum = recursive(dividendAbs - sum, divisorAbs);
			quotient += quotient_and_sum[0];
			sum += quotient_and_sum[1];
		}
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			if (quotient > (long) Integer.MAX_VALUE + 1) {// overflow
				return Integer.MAX_VALUE;
			} else {
				return (int) -quotient;
			}
		} else {
			if (quotient > Integer.MAX_VALUE) {// overflow
				return Integer.MAX_VALUE;
			} else {
				return (int) quotient;
			}
		}
	}

	private long[] recursive(long dividend, long divisor) {
//		System.out.println("recursive in :: " + dividend + " :: " + divisor);
		long power_of_two = -1;
		long sum = 0;
		while (divisor << ++power_of_two <= dividend) {
//			System.out.println(divisor + " ^ " + power_of_two + " :: " + (divisor << power_of_two));
			sum = divisor << power_of_two;
		}
		power_of_two--;
//		System.out.println("recursive out :: " + power_of_two + " :: " + Math.pow(2, power_of_two) + " :: " + sum);
		return new long[] { (long) Math.pow(2, power_of_two), sum };
	}

	public static void main(String[] args) {
//		System.out.println(new DivideTwoIntegers().divideBitOperations(17,2));
		System.out.println(new DivideTwoIntegers__Solved().divideBitOperations(7, -3));// -2
		System.out.println(new DivideTwoIntegers__Solved().divideBitOperations(-2147483648, -1));// 2147483647
		System.out.println(new DivideTwoIntegers__Solved().divideBitOperations(-2147483648, 1));// -2147483648

	}

}
