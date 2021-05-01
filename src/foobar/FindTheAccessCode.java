package foobar;

public class FindTheAccessCode {
	public static void main(String[] args) {
		int[] input = { 1, 1, 1 };
		System.out.println(solution(input));
	}

	public static int solution(int[] l) {
		int count = 0;
		for (int i = 0; i < l.length; i++) {
			int a = l[i];
			for (int j = i + 1; j < l.length; j++) {
				int b = l[j];
				if (b % a == 0) {
					for (int k = j + 1; k < l.length; k++) {
						int c = l[k];
						if (c % b == 0) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}
}
