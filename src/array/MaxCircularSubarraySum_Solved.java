package array;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxCircularSubarraySum_Solved {
//	
//	1
//	7
//	8 -8 9 -9 10 -11 12
//	Its Correct output is:
//	22
//
//	1
//	8
//	10 -3 -4 7 6 5 -4 -1
//	Its Correct output is:
//	23
//
//	2
//	15
//	787 656 543 291 27 165 659 736 232 351 237 28 75 207 274 
//	22
//	658 195 -171 37 35 593 618 228 -57 -189 728 329 576 204 243 563 413 338 406 640 704 618
//	Its Correct output is:
//	5268
//	7955
//
//	1
//	39
//	-175 188 -126 33 -43 481 293 158 70 499 217 639 369 163 422 594 -27 647 231 262 482 190 92 591 -143 -85 321 -43 374 291 747 751 31 -179 337 540 -146 -170 -102
//	Its Correct output is:
//	9367
//
//	1
//	27224
//	-32481 13497 16722 28925 22813 29907 -18450 17464 17063 19701 -26526 31593 -6881 -3208 1969 -16676 3583 22124 7962 -26546 -19851 -7537 5181 -19854 -6370 28894 -28049 -4585 5556 6381 21025 6438 -30855 845 23052 24927 32052 -32671 -12037 -9950 -12137 19450 31955 -22693 805 29031 12754 -23782 15679 -28774 3952 9612 -11232 15719 2736 5297 12036 -3409 31915 -12581 4350 -29183 8970 -10989 12017 18110 -28813 12225 -29015 27856 -11655 -3981 5245 -22508 26720 -12530 16645 -27324 -13842 21954 29795 -9053 -17068 -12167 14688 6114 12754 -17405 -12443 -17106 -20283 -8595 26883 -8102 -3890 -25582 2142 -5964 24341 2149 17349 15526 -17881 -4742 -10277 -22795 -21636 144 12991 18629 -26289 -4087 14761 10130 13072 20964 -9292 -19747 -11235 4018 29668 6560 12163 -32626 7171 4642 -2265 -18535 -11022 -19767 -16357 -22410 17086 -12130 14906 -1032 24736 -30616 -11135 959 -30357 -7108 22000 -12229 21331 30020 6875 6370 -23266 15721 23332 27664 3872 23035 -10178 -9986 -26686 31155 16959 -7322 -32065 192 2.................
//
//	Its Correct output is:
//	1903125
//
//	And Your Code's output is:
//	634081

	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		try {
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				int N = Integer.parseInt(br.readLine());
				String[] temp = br.readLine().split("\\s+");
				int[] arr = new int[N];
				boolean allNegFlag = true;
				boolean allPosFlag = true;
				long total = 0;
				for (int i = 0; i < N; i++) {
					arr[i] = Integer.parseInt(temp[i]);
					if (allNegFlag && arr[i] >= 0) {
						allNegFlag = false;
					}
					if (allPosFlag && arr[i] <= 0) {
						allPosFlag = false;
					}
					total += arr[i];
				}
				if (allNegFlag) {
					System.out.println(-1);
				} else if (allPosFlag) {
					System.out.println(total);
				} else {
					System.out.println(Math.max((total - minSolver(arr)), maxSolver(arr)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long minSolver(int[] arr) {

		int[] bigArr = new int[arr.length * 3];
		for (int i = 0; i < bigArr.length; i++) {
			bigArr[i] = arr[i % arr.length];
		}
		long sum = 0;
		long minSum = 0;
		int resetIndex = 0;
		for (int i = 0; i < 2 * arr.length; i++) {
			sum += bigArr[i];
			if (i >= arr.length && i - resetIndex >= arr.length) {
				sum -= bigArr[i - arr.length];
			}
			if (sum > 0) {
				resetIndex = i;
				sum = 0;
			}
			if (sum < minSum) {
				minSum = sum;
			}
//			System.out.print(bigArr[i] + " :: " + minSum);
//			System.out.println(" :: " + sum + " :: from " + Math.max(resetIndex, i - arr.length + 1) % arr.length
//					+ " to " + i % arr.length);
		}
//		System.out.println("min = " + minSum);
		return minSum;
	}

	private static long maxSolver(int[] arr) {

		int[] bigArr = new int[arr.length * 3];
		for (int i = 0; i < bigArr.length; i++) {
			bigArr[i] = arr[i % arr.length];
		}
		long sum = 0;
		long maxSum = 0;
		int resetIndex = 0;
		for (int i = 0; i < 2 * arr.length; i++) {
			sum += bigArr[i];
			if (i >= arr.length && i - resetIndex >= arr.length) {
				sum -= bigArr[i - arr.length];
			}
			if (sum < 0) {
				resetIndex = i;
				sum = 0;
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
//			System.out.print(bigArr[i] + " :: " + minSum);
//			System.out.println(" :: " + sum + " :: from " + Math.max(resetIndex, i - arr.length + 1) % arr.length
//					+ " to " + i % arr.length);
		}
//		System.out.println("max = " + maxSum);
		return maxSum;
	}
}
