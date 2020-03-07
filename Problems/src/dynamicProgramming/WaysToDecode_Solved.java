package dynamicProgramming;
public class WaysToDecode_Solved {
	public static void main(String[] args) {
		String A = "2611055971756562";
		System.out.println(A);
		System.out.println(new WaysToDecode_Solved().numDecodings(A));
	}

	public int numDecodings(String A) {
		int[] mem = new int[A.length() + 1];
		for (int i = 0; i < mem.length; i++) {
			mem[i] = -1;
		}
		long temp = recursive(0, A, mem, false);
//		System.out.print("mem :: ");
//		for (int i = 0; i < mem.length; i++) {
//			System.out.print(mem[i] + " ");
//		}
//		System.out.println();

		return (int) temp;

	}

	public int recursive(int index, String a, int[] mem, boolean flag2digit) {
		if (index < a.length()) {
			if (mem[index] != -1) {
//				System.out.println("extracting @ index " + index + " value = " + mem[index]);
				return mem[index];
			} else {
				if (a.charAt(index) == '0') {
					mem[index] = 0;
				}
				if (!flag2digit && a.charAt(index) == '0') {
//					System.out.println("found 0 @ " + index);
					return 0;
				} else {
					if (index == a.length() - 1) {
						mem[index] = 1;
						return 1;
					} else {
						int sum = 0;
						if ((a.charAt(index) == '1') || ((a.charAt(index) == '2') && (a.charAt(index + 1) <= '6'))) {
//							System.out.println(index + "-------1digit--------");
							int x = recursive(index + 1, a, mem, false);
//							System.out.println("1digit possibilities @ index  = " + index + " = " + x);
//							System.out.println(index + "-------2digit--------");
							int y = recursive(index + 2, a, mem, true);
//							System.out.println("2digit possibilities @ index  = " + index + " = " + y);
							sum = x + y;
						} else {
//							System.out.println(index + " :: " + a.charAt(index));
							sum = recursive(index + 1, a, mem, false);
						}
						mem[index] = sum;
						return sum;

					}

				}
			}

		} else {
			return 1;
		}

	}
}
