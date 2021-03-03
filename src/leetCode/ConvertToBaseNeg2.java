package leetCode;

public class ConvertToBaseNeg2 {
	public String convertBase(int N, int base) {
		char[] str = new char[32];
		for (int j = 0; j < str.length; j++) {
			str[j] = '0';
		}
		while (N != 0) {
			int pow = 1;
			System.out.println(N);
			System.out.println((int) Math.pow(base, pow));
			System.out.println(N % (int) Math.pow(base, pow));
			while (N % (int) Math.pow(base, pow) != 0) {
				System.out.println(N + " > " + Math.pow(base, pow) + " :: " + pow);
				pow++;
			}
			pow--;
			N = Math.floorMod(N, (int) Math.pow(base, pow));
			System.out.println(" :: j = " + pow + " :: N = " + N);
			str[31 - pow] = '1';
		}
		System.out.println(str);
		return String.valueOf(Integer.parseInt(String.valueOf(str)));
	}

	public static void main(String[] args) {
		System.out.println(new ConvertToBaseNeg2().convertBase(20,2));// 110
//		System.out.println(new ConvertToBaseNeg2().baseNeg2(3));// 111
	}

//	public String BaseNeg2(int N) {
//		
//	}
}
